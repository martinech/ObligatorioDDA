package controladores;

import dominio.EstadoPedido;
import dominio.Gestor;
import dominio.Pedido;
import dominio.Servicio;
import excepciones.PollomorfismoException;
import java.util.List;
import logica.Fachada;
import observador.Observable;
import observador.Observador;
import vistas.VistaGestor;

public class ControladorGestor implements Observador{
    
    private VistaGestor vista;
    private Gestor gestor;
    
    public ControladorGestor(VistaGestor vista, Gestor gestor){
        this.vista = vista;
        this.gestor = gestor;
        Fachada.getInstancia().agregarObservador(this);
        refrescarListar();
     
        
    }

    public void refrescarListar() {
        vista.mostrarError("");
        List<Pedido> pendientes = Fachada.getInstancia().getPedidosPendientesPorUnidad(gestor.getUnidadProcesadora());
        List<Pedido> tomados = Fachada.getInstancia().getPedidosTomadosPorGestor(gestor);
        vista.mostrarPedidosPendientes(pendientes);
        vista.mostrarPedidosTomados(tomados);
    }
    
    public void tomarPedido(int pos){
        //1 recupero la lista actual de pedidos pendientes
        List<Pedido> pendientes = Fachada.getInstancia().getPedidosPendientesPorUnidad(gestor.getUnidadProcesadora());
        
        //valido la seleccion
        if(pos < 0 || pos >= pendientes.size()){
            vista.mostrarError("Debe seleccionar un pedido pendiente");
            return;
        }
        
        //asigno el gestor y cambio de estado 
        Pedido p = pendientes.get(pos);
        try{
            Fachada.getInstancia().asignarPedidosAGestor(p, gestor);
            refrescarListar();
            vista.mostrarError("");
        }catch(PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
        //refresco la vista (reobtengo listas)
        //refrescarListar();
    }
    
    public void finalizarPedido(int pos){
        List<Pedido> tomados = Fachada.getInstancia()
        .getPedidosTomadosPorGestor(gestor);
        if(pos <0 || pos >= tomados.size()){
            vista.mostrarError("Seleccione un pedido tomado.");
            return;
        }
        
        Pedido p = tomados.get(pos);
        try{
            Fachada.getInstancia().finalizarPedido(p, gestor);
            refrescarListar();
            vista.mostrarError("");
        }catch(PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void entregarPedido(int pos){
        List<Pedido> tomados = Fachada.getInstancia()
        .getPedidosTomadosPorGestor(gestor);
        if(pos <0 || pos>= tomados.size()){
            vista.mostrarError("Seleccione un pedido finalizado.");
            return;
        }
        Pedido p = tomados.get(pos);
        try{
            Fachada.getInstancia().entregarPedido(p, gestor);
            refrescarListar();
            vista.mostrarError("");
        }catch(PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
    }   
        
     @Override
    public void actualizar(Observable origen, Object evento) {
        //cuando un cliente confirme pedidos (en fachada) lo actualizamos
        if(evento == Servicio.eventos.nuevoPedido || evento == Servicio.eventos.confirmarServicio || evento == Servicio.eventos.pedidoFinalizado){
            refrescarListar();
        }
        if(evento == Fachada.eventos.logoutGestor){
            //la lista del gestor se limpia?
        }
    }

    public boolean logout(Gestor gestor) {
        try{
            return Fachada.getInstancia().logoutGestor(gestor);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
        return false;
    }
    
    
}
