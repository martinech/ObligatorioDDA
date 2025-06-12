/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.Categoria;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public interface VistaCliente {
       
    public void cargarCategorias(ArrayList<Categoria> categorias);
    
    public void cargarItems();
    
    public void cargarPedidos(); //esto lo tiene que hacer la vista cliente tambien? o solo VistaRealizarPedido

    public void mostrarError(String message);
    
}
