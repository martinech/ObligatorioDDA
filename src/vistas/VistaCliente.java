/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Pedido;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public interface VistaCliente {
       
    public void cargarCategorias(ArrayList<Categoria> categorias);
    
    public void cargarItemsCategoria(Categoria categoria);
        
    public void mostrarPedidosServicio(ArrayList<Pedido> pedidos);
    
    public void loginExitoso(Cliente cliente);

    public void mostrarError(String message);
    
    public void mostrarMensaje(String message);

    public void resetInterfaz();

    public void marcarPagoPendiente();
    
    
    
}
