/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author HP
 */
public class Frecuente extends Cliente{
    
    public Frecuente(String id, String password, String nombreCompleto) {
        super(id, password, nombreCompleto);
    }
    
    @Override
        public double calcularDescuento(Servicio servicio){
        double descuento =0;
        for(Pedido p : servicio.getPedidos()){
            if(p.getEstado() != EstadoPedido.CONFIRMADO) continue;
            if(p.getItem().getNombre().equalsIgnoreCase("Café")){
                descuento += p.getItem().getPrecioUnitario();
            }
        }
        return descuento;
    }
        
    @Override
    public String descripcionBeneficio(Servicio servicio){
        return "Café de cortesía.";
    }
}
