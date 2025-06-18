/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dominio.Cliente;
import logica.Fachada;
import dominio.Gestor;
import excepciones.PollomorfismoException;
import observador.Observable;
import observador.Observador;
import vistas.VistaLoginGestor;

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

public class ControladorLoginGestor{
    
    private VistaLoginGestor vista;
    
    public ControladorLoginGestor(VistaLoginGestor v){
        this.vista = v;
        //Fachada.getInstancia().agregarObservador(this);
        //settitle
    }
    
    public void loginGestor(String nomUsuario, String password) {
        try{
            Gestor gestor = Fachada.getInstancia().loginGestor(nomUsuario, password);
            vista.loginGestorExitoso(gestor);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
    }

   /* @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
}
