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
import java.util.HashMap;

/**
 *
 * @author marti
 */
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
    
}
