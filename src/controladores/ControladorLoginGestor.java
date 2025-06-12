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

/**
 *
 * @author marti
 */
public class ControladorLoginGestor implements Observador{
    
    private VistaLoginGestor vista;
    
    public ControladorLoginGestor(VistaLoginGestor v){
        this.vista = v;
        Fachada.getInstancia().agregarObservador(this);
        //settitle
    }
    
    public Gestor loginGestor(String nomUsuario, String password) {
        try{
            return Fachada.getInstancia().loginGestor(nomUsuario, password);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
