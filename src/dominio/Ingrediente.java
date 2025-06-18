/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author marti
 */
public class Ingrediente {
    
    private Insumo insumo;
    
    private int cantidad;
    
    private ItemMenu item; 

    public Ingrediente(Insumo insumo, int cantidad, ItemMenu item) {
        this.insumo = insumo;
        this.cantidad = cantidad;
        this.item = item;
    }

    public ItemMenu getItem() {
        return item;
    } 

    public Insumo getInsumo() {
        return insumo;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public boolean estaDisponible(){
        return insumo.getStockAct()-insumo.getStockMin() >= cantidad;
    }
    
    

}
