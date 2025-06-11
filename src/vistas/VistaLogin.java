/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

/**
 *
 * @author marti
 */
public interface VistaLogin {
       
    public void cargarCategorias();
    
    public void cargarItems();
    
    public void cargarPedidos();

    public void mostrarError(String message);
    
}
