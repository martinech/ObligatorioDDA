/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author marti
 */
public class Gestor extends Usuario{
    
    private String nombreUsuario;
      
    private UnidadProcesadora unidadProcesadora;

    public Gestor(String nombreUsuario, String password, String nombreCompleto, UnidadProcesadora unidadProcesadora) {
        super(password, nombreCompleto);
        this.nombreUsuario = nombreUsuario;
        this.unidadProcesadora = unidadProcesadora;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    @Override
    public boolean verificarCredenciales(String nomUsuario, String password) {
        if(this.nombreUsuario.equals(nomUsuario) && this.password.equals(password)) {
            return true;
        }
        return false;
    }

    
    
}
