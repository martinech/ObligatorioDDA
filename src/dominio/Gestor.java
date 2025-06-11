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

    public Gestor(String password, String nombreCompleto, String nombreUsuario, UnidadProcesadora unidadProcesadora) {
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
    public boolean verificarCredenciales(String id, String password) {
        if(nombreUsuario == id && this.password==password) {
            return true;
        }
        return false;
    }

    
    
}
