
package dominio;

import static dominio.EstadoPedido.CONFIRMADO;
import static dominio.EstadoPedido.NO_CONFIRMADO;
import excepciones.PollomorfismoException;
import java.util.ArrayList;
import observador.Observable;
import excepciones.PollomorfismoException;
import java.util.Iterator;

public class Servicio extends Observable{

   
    
    public enum eventos{nuevoPedido, pedidoEliminado, confirmarServicio, pedidoFinalizado, pedidoEntregado};
    
    private Cliente cliente;
    
    private static int contador = 1;
    
    private int id;
    
    private double total;

    private ArrayList<Pedido> pedidos;

    public Servicio(Cliente cliente) {
        this.cliente = cliente;
        this.id = contador++;
        this.total = 0;
        this.pedidos = new  ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }  

    public static int getContador() {
        return contador;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void chequearPedidoSinStock(){
        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()){
            Pedido p = it.next();
            if(p.getEstado() == EstadoPedido.NO_CONFIRMADO &&
                    !p.getItem().hayStockSuficiente()){
                it.remove();
                avisar("stockQuitado: "+ p.getItem().getNombre());
            }
        }
    }
    
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
        this.avisar(Servicio.eventos.nuevoPedido);
    }
    
    public void eliminarPedido(int pos) throws PollomorfismoException{
        Pedido pSeleccionado = pedidos.get(pos);
        
        switch (pSeleccionado.getEstado()) {
            case NO_CONFIRMADO:
                pedidos.remove(pSeleccionado);
                this.avisar(Servicio.eventos.pedidoEliminado);
                break;

            case CONFIRMADO:
                pSeleccionado.getItem().reintegrarStock();
                pedidos.remove(pSeleccionado);
                this.avisar(Servicio.eventos.pedidoEliminado);
                break;

            default:
                throw new PollomorfismoException("Un poco tarde… Ya estamos elaborando este pedido!");
        }
    }
    
    public String[] confirmarPedidos() {
       ArrayList<String> mensajes = new ArrayList<>();
       
        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()){
            Pedido p = it.next();

            if(p.getEstado() == EstadoPedido.NO_CONFIRMADO){
                if(p.getItem().estaDisponible()){
                    p.getItem().descontarStock();
                    p.setEstado(EstadoPedido.CONFIRMADO);
                    this.total += p.getItem().getPrecioUnitario();
                }else{
                    mensajes.add("Nos hemos quedado sin stock de " + p.getItem().getNombre()+ ", no pudimos avisar antes.");
                    it.remove();
                }
            }
        }
        this.avisar(eventos.confirmarServicio);
        return mensajes.toArray(new String[0]);
    }
    
    public boolean hayPedidosNoConfirmados() {
        for (Pedido p : pedidos){
            if(p.getEstado() == EstadoPedido.NO_CONFIRMADO){
                return true;
            }
        }
        return false;
    }
    
    
    public String finalizarServicio() {
        
        if(cliente == null){
            return "No hay cliente identificado.";
        }
        
        // Beneficio por tipo de cliente
        double descuento = cliente.calcularDescuento(this);
        String beneficio = cliente.descripcionBeneficio(this);
        double totalFinal = this.total - descuento;

        //pedidos pendientes de entrega
        long pendientes = pedidos.stream()
                .filter(p -> p.getEstado() != EstadoPedido.ENTREGADO)
                .count();
        String msjPendiente = (pendientes > 0)? "\nTienes " + pendientes + " pedidos en proceso. Recuerda retirarlos.": "";
        
        //Libero el dispositivo
        Dispositivo disp = cliente.getDispositivo();
        if(disp !=null){
            disp.setEstado(EstadoDispositivo.DISPONIBLE);
            disp.setCliente(null);
            cliente.setDispositivo(null);
        }
        
        //mensaje para mostrar antes de limpar todo
        String msjFinal = "Pago realizado. \nBeneficio: "+ beneficio + 
                "\nTotal a pagar: $ "+ totalFinal + msjPendiente + "Pulse Confirmar para continuar";

        // Reset de servicio
        this.cliente = null;
        this.pedidos.clear();
        this.total = 0;

        return msjFinal;
    }
    
    
    
    
    
}
