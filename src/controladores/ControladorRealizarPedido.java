
package controladores;

import dominio.Categoria;
import dominio.Cliente;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import excepciones.PollomorfismoException;
import java.util.ArrayList;
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
        if(evento instanceof String ev && ev.startsWith("StockQuitado")){
            String item = ev.substring("stockQuitado:".length());
            vista.mostrarError("Nos hemos quedado sin stock de " + item + ", no pudimos avisar antes.");
        }            
        if (evento == Servicio.eventos.nuevoPedido) {            
            vista.mostrarPedidosServicio(servicio.getPedidos());
        }
        if (evento == Servicio.eventos.pedidoEliminado){
            vista.mostrarPedidosServicio(servicio.getPedidos());
        }
        if (evento == Servicio.eventos.confirmarServicio){
            vista.mostrarPedidosServicio(servicio.getPedidos());
        }
    }

    public void agregarPedido(int  idxItem, String comentario, Categoria catActual) {
        //validaciones de dominio
        //cliente logueado
        if(servicio == null || servicio.getCliente() == null){
            vista.mostrarError("Debe identificarse antes de realizar pedidos.");
            return;
        }
        
        //categoria seleccionada
        if(catActual == null){
            vista.mostrarError("Debe seleccionar una categoria.");
            return;
        }
        
        //indice del item dentro del rango
        if(idxItem < 0 || idxItem >= catActual.getItemsMenu().size()){
            vista.mostrarError("Debe seleccionar un item.");
            return;
        }
        
        //creo el pedido y lo registro
        ItemMenu item = catActual.getItemsMenu().get(idxItem);
        Pedido ped = new Pedido(comentario, item, servicio.getCliente());
        
        servicio.agregarPedido(ped);
        
    }
    
    
    
    public void comenzarServicio(Cliente cliente){
        Fachada.getInstancia().comenzarServicio(cliente);
    }

    public void eliminarPedido(int pos) {
        
        //validaciones del dominino 
        //esta logueado
        if(servicio == null || servicio.getCliente() == null){
            vista.mostrarError("Debe idenfiticarse antes de confirmar el servicio.");
            return;
        }

        //indice valido
        if(pos < 0 || pos>= servicio.getPedidos().size()){
            vista.mostrarError("Debe seleccionar un pedido.");
            return;
        }

        //se puede eliminar
        Pedido sel = servicio.getPedidos().get(pos);
        if(!sel.esEliminable()){
            vista.mostrarError("Un poco tarde... El pedido ya esta en preparación.");
            return;
        }
        
        //elimina
   
        try{
            servicio.eliminarPedido(pos);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }   
    }
    
    public void confirmarServicio(){
        //validaciones del dominino 
        //esta logueado
        if(servicio == null || servicio.getCliente() == null){
            vista.mostrarError("Debe idenfiticarse antes de confirmar el servicio.");
            return;
        }
        
        
        if(!servicio.hayPedidosNoConfirmados()){
            vista.mostrarError("No hay nuevos pedidos.");
            return;
        }
        
       
        String[] mensajes = servicio.confirmarPedidos();
        for (String mensaje : mensajes){
            vista.mostrarError(mensaje);
        } 
    }
    
    
    public void finalizarServicio(){
        //valido cliente logueado
        if(servicio == null || servicio.getCliente() == null){
            vista.mostrarError("Debe identificarse para finalizar el servicio.");
            return;
        }
        //valido servicios sin confirmar
        if(servicio.hayPedidosNoConfirmados()){
            vista.mostrarError("Tienes pedidos sin confirmar.");
            return;
        }
        if(servicio.getPedidos().size()==0){
            return;
        }
        
        String mensaje = servicio.finalizarServicio();
        vista.mostrarMensaje(mensaje);
        vista.marcarPagoPendiente();
    }
    
    
}
