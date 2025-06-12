/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dominio.Cliente;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class SistemaPedidos {
    
    private ArrayList<Servicio> servicios = new ArrayList();
    
    public void comenzarServicio(Cliente cliente){
        Servicio servicio = new Servicio(cliente);
    }   
    
    public void agregarPedidoAServicioCliente(Cliente cliente, Pedido pedido){
        for(Servicio s:servicios){
            if(s.getCliente() == cliente){
                s.agregarPedido(pedido);
            }
        }
    }
    
}
