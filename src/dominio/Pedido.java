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
public class Pedido {
    
    private String comentario;
    
    private EstadoPedido estado;
    
    private ArrayList<ItemMenu> items;

    public String getComentario() {
        return comentario;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public ArrayList<ItemMenu> getItems() {
        return items;
    }
    
}
