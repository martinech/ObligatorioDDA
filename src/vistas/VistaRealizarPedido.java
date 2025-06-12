/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.Categoria;

/**
 *
 * @author marti
 */
public interface VistaRealizarPedido {
        
    public void cargarItemsCategoria(Categoria categoria);
    
    public void cargarPedidos();
    
}
