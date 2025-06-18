
package logica;

import dominio.Cliente;
import dominio.EstadoPedido;
import static dominio.EstadoPedido.ENTREGADO;
import dominio.Gestor;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import dominio.UnidadProcesadora;
import excepciones.PollomorfismoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import observador.Observador;


public class SistemaPedidos {
    
    private ArrayList<Servicio> servicios = new ArrayList();
    
    private HashMap<Cliente, Servicio> serviciosActivos = new HashMap<>();
    
    public Servicio comenzarServicio(Cliente cliente){
        Servicio servicio = new Servicio(cliente);
        serviciosActivos.put(cliente, servicio);
        return servicio;
    }   
    
    //no es lo mas performante que se recorran todos los servicios para agregar el pedido capaz se le puede pasar el servicio.
    //este metodo no sirve? ya sea agrega e
   /* public void agregarPedidoAServicioCliente(Servicio servicio, Pedido pedido){
        servicio.agregarPedido(pedido);
    }*/
    
    
    public ArrayList<Pedido> getPedidosDelServicio(Cliente cliente){
        Servicio servicio = serviciosActivos.get(cliente);
        if(servicio == null){
            return new ArrayList<>(); // o lanzo excepcion
        }
        return servicio.getPedidos();
    }
    
    public void finalizarServicio(Cliente cliente){
        serviciosActivos.remove(cliente);
    }
    
    //pedidos confirmados sin gestor asignado para una unidad procesadora
    public List<Pedido> getPedidosPendientesPorUnidad(UnidadProcesadora up){
        List<Pedido> resultado = new ArrayList<>();
        for(Servicio s : serviciosActivos.values()){
            for(Pedido p : s.getPedidos()){
                if(p.getEstado()== EstadoPedido.CONFIRMADO &&
                        p.getGestor() == null && p.getItem().getUnidadProcesadora().equals(up)){
                    resultado.add(p);
                }
            }
        }
        return resultado;
    }
    
    //pedidos asignados al gestor dado
    public List<Pedido> getPedidosTomadosPorGestor(Gestor g){
        List <Pedido> resultado = new ArrayList<>();
        for(Servicio s : serviciosActivos.values()){
            for(Pedido p : s.getPedidos()){
                if(g.equals(p.getGestor())){
                    resultado.add(p);
                }
            }
        }
        return resultado;
    }   
    
    //metodo para asignar los pedidos y poner en proceso y avisar al servicio
    public void asignarPedidosAGestor(Pedido ped, Gestor ges) throws PollomorfismoException{
        //1 busco el servicio que contiene ese pedido
        for(Servicio s : serviciosActivos.values()){
            if(s.getPedidos().contains(ped)){
                //2 asignar
                ped.setGestor(ges);
                ped.setEstado(EstadoPedido.EN_PROCESO);
                //notificar a los observadores del servicio
                s.avisar(Servicio.eventos.confirmarServicio);
                return;
            }
        }
        throw new PollomorfismoException("El pedido no pertenece a ningún servicio activo.");
    }
    
    //metodo que marca el pedido como finalizado y avisa al servicio
    public void finalizarPedido(Pedido ped, Gestor ges) throws PollomorfismoException{
        //1 busco el servicio que contiene ese pedido
        Servicio servicioEncontrado = null;
        for(Servicio s : serviciosActivos.values()){
            if(s.getPedidos().contains(ped)){
                servicioEncontrado = s;
                break;
            }
        }
        if(servicioEncontrado == null ) throw new PollomorfismoException("El pedido no pertenece a ningun servicio activo.");
        //2 verifico que el gestor lo tenga asignado
        if(!ges.equals(ped.getGestor())) throw new PollomorfismoException("No puede finalizar un pedido que no haya tomado ud.");
        //3 cambio estado y notifico
        ped.finalizar();
        servicioEncontrado.avisar(Servicio.eventos.pedidoFinalizado);        
    }
    
    public void entregarPedido(Pedido ped, Gestor ges) throws PollomorfismoException{
        Servicio servicioEncontrado = null;
        for(Servicio s : serviciosActivos.values()){
            if(s.getPedidos().contains(ped)){
                servicioEncontrado = s;
                break;
            }
        }
        if(servicioEncontrado == null) throw new PollomorfismoException("El pedido no pertenece al servicio activo.");
        if(!ges.equals(ped.getGestor())) throw new PollomorfismoException("No puede entregar un pedido que no haya tomado ud.");
        if(ped.getEstado() == ENTREGADO) throw new PollomorfismoException("El pedido ya está entregado");
        ped.entregar();
        servicioEncontrado.avisar(Servicio.eventos.pedidoEntregado);
    }
    
    
    
    
}
