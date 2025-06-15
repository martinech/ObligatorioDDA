/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dominio.Cliente;
import dominio.Pedido;
import dominio.Servicio;
import excepciones.PollomorfismoException;
import logica.Fachada;
import observador.Observable;
import observador.Observador;
import vistas.VistaCliente;

/*
///CONTROLADOR -> IMPLEMENTS Observador///
-Atributos: vista y/o objeto del dominio
-Constructor:
    *Vista
    *Objeto del dominio y/o fachada
    *Agregarse como observador del objeto del dominio o fachada
    *Inicializar la vista
-Eventos del usuario(click en botones, seleccionar listas, etc.)
-Codigo para inicializar la vista
-Codigo para finalizar la vista -> quitarse como observador / otros si aplica
-Responder a los eventos del modelo/fachada -> actualizar el Observador
*/

public class ControladorRealizarPedido implements Observador{
    
    private VistaCliente vista;
    
    private Servicio servicio;
    
    public ControladorRealizarPedido(VistaCliente v, Servicio s){
        this.vista = v;
        this.servicio = s;
        servicio.agregarObservador(this);
        
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento == Servicio.eventos.nuevoPedido) {            
            vista.mostrarPedidosServicio(servicio.getPedidos());            
        }
        if (evento == Servicio.eventos.pedidoEliminado){
            vista.mostrarPedidosServicio(servicio.getPedidos());
        }
    }

    public void agregarPedido(Pedido pedido) {
        Fachada.getInstancia().agregarPedidoAServicioCliente(servicio, pedido);
    }
    
    public void comenzarServicio(Cliente cliente){
        Fachada.getInstancia().comenzarServicio(cliente);
    }

    public void eliminarPedido(int pos) {
        try{
            servicio.eliminarPedido(pos);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
        
    }
    
}
