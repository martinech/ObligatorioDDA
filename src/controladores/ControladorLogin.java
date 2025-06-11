/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dominio.Cliente;
import dominio.Fachada;
import observador.Observable;
import observador.Observador;
import vistas.VistaLogin;

/**
 *
 * @author marti
 */
public class ControladorLogin implements Observador{
    
    private VistaLogin vista;
    
    private Cliente cliente;
    
    public ControladorLogin(VistaLogin v, Cliente c){
        this.vista = v;
        this.cliente = c;
        Fachada.getInstancia().agregarObservador(this);
        //vista.setTitle("Esperando acceso");
    }
 
    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
