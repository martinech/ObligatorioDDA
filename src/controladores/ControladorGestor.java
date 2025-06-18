package controladores;

import dominio.Gestor;
import dominio.Pedido;
import dominio.Servicio;
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
        //refrescarListar();
     
        
    }
    
    
    
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        //cuando un cliente confirme pedidos (en fachada) lo actualizamos
        if(evento == Servicio.eventos.nuevoPedido || evento == Servicio.eventos.confirmarServicio){
            refrescarListar();
        }
    }

    public void refrescarListar() {
        List<Pedido> pendientes = Fachada.getInstancia().getPedidosPendientesPorUnidad(gestor.getUnidadProcesadora());
        List<Pedido> tomados = Fachada.getInstancia().getPedidosTomadosPorGestor(gestor);
        vista.mostrarPedidosPendientes(pendientes);
        vista.mostrarPedidosTomados(tomados);
    }
    
    
    
}
