/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author HP
 */
public class DeLaCasa extends Cliente{
    
    public DeLaCasa(String id, String password, String nombreCompleto) {
        super(id, password, nombreCompleto);
    }
    
    
    @Override
    public double calcularDescuento(Servicio servicio){
        return Math.min(500, servicio.getTotal());
    }
    
    @Override
    public String descripcionBeneficio(Servicio servicio){
        return "$500 de consumo por cuenta de la casa.";
    }
}
