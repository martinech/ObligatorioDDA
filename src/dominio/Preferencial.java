/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author HP
 */
public class Preferencial extends Cliente{
    
    public Preferencial(String id, String password, String nombreCompleto) {
        super(id, password, nombreCompleto);
    }
    
    
    @Override
    public double calcularDescuento(Servicio servicio){
        double subTotal = 0;
        double descAgua = 0;
    
       for(Pedido p : servicio.getPedidos()){
           if(p.getEstado() != EstadoPedido.CONFIRMADO) continue;
           
           double precio = p.getItem().getPrecioUnitario();
           subTotal += precio;
           
           if(p.getItem().getNombre().toLowerCase().contains("agua")){
               descAgua += precio;
           }
       }
       double totalSinAgua = subTotal - descAgua;
       double desc5 = (totalSinAgua > 2000) ? totalSinAgua * 0.05 : 0;
       
       return descAgua + desc5;
    }
    
    @Override
    public String descripcionBeneficio(Servicio servicio){
        return "Agua Mineral gratis + 5% descuento en compra mayor a $2000.";
    }
}
