/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dominio.Cliente;
import dominio.Pedido;
import logica.Fachada;
import observador.Observable;
import observador.Observador;
import vistas.VistaRealizarPedido;

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
    
    private VistaRealizarPedido vista;
    
    public ControladorRealizarPedido(VistaRealizarPedido v){
        this.vista = v;
        Fachada.getInstancia().agregarObservador(this);
        
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        //if(evento == Fachada.eventos.)
    }

    public void agregarPedido(Cliente cliente, Pedido pedido) {
        Fachada.getInstancia().agregarPedidoAServicioCliente(cliente, pedido);
    }
    
    public void comenzarServicio(Cliente cliente){
        Fachada.getInstancia().comenzarServicio(cliente);
    }
    
}
