    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marti
 */
public class Insumo {
    
    private String nombre;
    
    private int stockMin;
    
    private int stockAct;
    
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public Insumo(String nombre, int stockMin, int stockAct) {
        this.nombre = nombre;
        this.stockMin = stockMin;
        this.stockAct = stockAct;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getStockMin() {
        return stockMin;
    }

    public int getStockAct() {
        return stockAct;
    }

    public void descontar(int cantidad) {
        this.stockAct -= cantidad;
    }
    
    public void reintegrar(int cantidad) {
        this.stockAct += cantidad;
    }
}
