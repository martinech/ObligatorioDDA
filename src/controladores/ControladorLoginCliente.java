/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dominio.Categoria;
import dominio.Cliente;
import logica.Fachada;
import excepciones.PollomorfismoException;
import java.util.ArrayList;
import observador.Observable;
import observador.Observador;
import vistas.VistaCliente;

/**
 *
 * @author marti
 */
public class ControladorLoginCliente implements Observador{
       
    private VistaCliente vista;
    
    public ControladorLoginCliente(VistaCliente v){
        this.vista = v;
        Fachada.getInstancia().agregarObservador(this);
    }
 
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento == Fachada.eventos.loginCliente){
            vista.cargarCategorias(Fachada.getInstancia().getCategorias());
        }
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