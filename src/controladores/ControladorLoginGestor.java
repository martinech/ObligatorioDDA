/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import logica.Fachada;
import dominio.Gestor;
import excepciones.PollomorfismoException;
import vistas.VistaLoginGestor;


public class ControladorLoginGestor {
    
    private VistaLoginGestor vista;
    
    public ControladorLoginGestor(VistaLoginGestor v){
        this.vista = v;
    }
    
    public void loginGestor(String nomUsuario, String password) {
        try{
            Gestor gestor = Fachada.getInstancia().loginGestor(nomUsuario, password);
            vista.loginGestorExitoso(gestor);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
}
