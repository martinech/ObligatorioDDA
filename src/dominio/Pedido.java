
package dominio;

import excepciones.PollomorfismoException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Pedido {
    
    private String comentario;
    private EstadoPedido estado = EstadoPedido.NO_CONFIRMADO; 
    private ItemMenu item;
    private Gestor gestor;
    private UnidadProcesadora unidadProcesadora;
    private String nombreCliente;
    private LocalDateTime fechaCreacion;
    
    
    public Pedido(String comentario, ItemMenu item, Cliente cliente){
        this.comentario = comentario;
        this.item = item;
        this.unidadProcesadora = item.getUnidadProcesadora();
        this.nombreCliente =cliente.getNombreCompleto();
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public String getComentario() {
        return comentario;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public ItemMenu getItem() {
        return item;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor){
        this.gestor = gestor;
    }
    
    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public boolean esEliminable() {
        return this.estado == EstadoPedido.NO_CONFIRMADO;
    }

    void confirmarPedido() {
        estado = EstadoPedido.CONFIRMADO;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
    public void finalizar() throws PollomorfismoException{
        if(estado != EstadoPedido.EN_PROCESO){
            throw new PollomorfismoException("El pedido debe estar en proceso para finalizarlo.");
        }
        this.estado = EstadoPedido.FINALIZADO;
    }
    
    public void entregar() throws PollomorfismoException{
        if(estado != EstadoPedido.FINALIZADO){
            throw new PollomorfismoException("El pedido debe estar finalizado para entregarse.");
        }
        this.estado = EstadoPedido.ENTREGADO;
    }
  
}
