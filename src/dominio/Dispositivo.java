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
    
    private static int contador = 1;
    
    private int id;
    
    private EstadoDispositivo estado;
    
    private Cliente cliente;

    public Dispositivo() {
        this.id = contador++;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
