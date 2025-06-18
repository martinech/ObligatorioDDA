
package logica;

import dominio.Cliente;
import dominio.EstadoPedido;
import dominio.Gestor;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import dominio.UnidadProcesadora;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
    public void agregarPedidoAServicioCliente(Servicio servicio, Pedido pedido){
        servicio.agregarPedido(pedido);
    }
    
    
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
    //pedidos confirmados sin gestor asignado par auna unidad procesadora
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
    
    
    
}
