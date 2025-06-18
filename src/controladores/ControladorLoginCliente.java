
package controladores;

import dominio.Categoria;
import dominio.Cliente;
import logica.Fachada;
import excepciones.PollomorfismoException;
import java.util.ArrayList;
import observador.Observable;
import observador.Observador;
import vistas.VistaCliente;

/*
///CONTROLADOR -> IMPLEMENTS Observador///
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

public class ControladorLoginCliente implements Observador{
       
    private VistaCliente vista;
    
    private Cliente cliente;
    
    public ControladorLoginCliente(VistaCliente v){
        this.vista = v;
        Fachada.getInstancia().agregarObservador(this);
    }
 
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento == Fachada.eventos.loginCliente){
            vista.cargarCategorias(Fachada.getInstancia().getCategorias());            
            vista.mostrarPedidosServicio(Fachada.getInstancia().getPedidosDelServicio(cliente));
        }
    }

    public void loginCliente(String numCliente, String password) {
        try{
            this.cliente = Fachada.getInstancia().loginCliente(numCliente, password);
            vista.loginExitoso(cliente);
            Fachada.getInstancia().comenzarServicio(cliente);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
    }

}