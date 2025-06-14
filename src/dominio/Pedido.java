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
    private EstadoPedido estado = EstadoPedido.NO_CONFIRMADO; 
    private ItemMenu item;
    private Gestor gestor;
    private UnidadProcesadora unidadProcesadora;
    
    
    public Pedido(String comentario, ItemMenu item){
        this.comentario = comentario;
        this.item = item; 
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
    
    
}
