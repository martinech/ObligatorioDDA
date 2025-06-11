/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author marti
 */
public class Dispositivo {
    
    private int id;
    
    private EstadoDispositivo estado;
    
    

    public Dispositivo(int id) {
        this.id = id;
        this.estado = estado.DISPONIBLE;
    }

    public int getId() {
        return id;
    }

    public EstadoDispositivo getEstado() {
        return estado;
    }

    public void setEstado(EstadoDispositivo estado) {
        this.estado = estado;
    }
    
    
    
}
