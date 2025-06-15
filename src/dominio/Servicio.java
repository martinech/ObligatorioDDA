/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import excepciones.PollomorfismoException;
import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author marti
 */
public class Servicio extends Observable{
    
    public enum eventos{nuevoPedido, pedidoEliminado};
    
    private Cliente cliente;
    
    private static int contador = 1;
    
    static int id;
    
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
    
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
        this.avisar(Servicio.eventos.nuevoPedido);
    }
    
    public void eliminarPedido(int pos) throws PollomorfismoException{
        Pedido pSeleccionado = pedidos.get(pos);
        if(pSeleccionado.esEliminable()){
            pedidos.remove(pSeleccionado);
            this.avisar(Servicio.eventos.pedidoEliminado);
        } else {
            throw new PollomorfismoException("Un poco tarde…Ya estamos elaborando este pedido!");
        }
        
    }
}
