/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

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
    
    private void loginCliente(String id, String password){
        sAcceso.loginCliente(id,password);
    }

}
