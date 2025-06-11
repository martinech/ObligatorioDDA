/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author marti
 */
public class Usuario {
    
    private String password;
    
    private String nombreCompleto;

    public Usuario(String password, String nombreCompleto) {
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public boolean validar(){
        if(password == null || password.isBlank() || nombreCompleto == null || nombreCompleto.isBlank()){
            return false;
        }
        return true;
    }
    
}
