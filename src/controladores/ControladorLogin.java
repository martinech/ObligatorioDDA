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
import vistas.VistaLogin;

/**
 *
 * @author marti
 */
public class ControladorLogin implements Observador{
       
    private VistaLogin vista;
    
    public ControladorLogin(VistaLogin v){
        this.vista = v;
        Fachada.getInstancia().agregarObservador(this);
        //vista.setTitle("Esperando acceso");
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
