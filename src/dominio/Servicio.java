/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class Servicio {
    
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
    }
    

}
