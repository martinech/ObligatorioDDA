/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import excepciones.PollomorfismoException;
import observador.Observable;

/**
 *
 * @author marti
 */
public class Fachada extends Observable{
    
    public enum eventos {loginCliente, loginGestor};
    
    private SistemaAcceso sAcceso = new SistemaAcceso();
    
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
    }

    public SistemaAcceso getsAcceso() {
        return sAcceso;
    }
    
    public void agregarCliente(String numCliente, String password, String nombreCompleto){
        sAcceso.agregarCliente(numCliente, password, nombreCompleto);
    }
    
    public void agregarGestor(String password, String nombreCompleto, String nombreUsuario, UnidadProcesadora unidadProcesadora){
        sAcceso.agregarGestor(password, nombreCompleto, nombreUsuario, unidadProcesadora);
    }
    
    public Cliente loginCliente(String id, String password) throws PollomorfismoException{
        return sAcceso.loginCliente(id,password);
    }

}
