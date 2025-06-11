/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dominio.Cliente;
import dominio.Fachada;
import excepciones.PollomorfismoException;
import javax.swing.JOptionPane;
import observador.Observable;
import observador.Observador;
import vistas.VistaLoginCliente;

/**
 *
 * @author marti
 */
public class ControladorLoginCliente implements Observador{
       
    private VistaLoginCliente vista;
    
    public ControladorLoginCliente(VistaLoginCliente v){
        this.vista = v;
        Fachada.getInstancia().agregarObservador(this);
    }
 
    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Cliente loginCliente(String numCliente, String password) {
        try{
            return Fachada.getInstancia().loginCliente(numCliente, password);
        } catch (PollomorfismoException e){
            vista.mostrarError(e.getMessage());
            return null;
        }
    }
    
    
    
}
