
package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marti
 */
public class ItemMenu {
    
    private String nombre;
    
    private double precioUnitario;
    
    private ArrayList<Ingrediente> ingredientes;
    
    private UnidadProcesadora unidadProcesadora;
    
    private Categoria categoria;

    public ItemMenu(String nombre, double precioUnitario, 
            ArrayList<Ingrediente> ingredientes, 
            UnidadProcesadora unidadProcesadora, 
            Categoria categoria) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.ingredientes = ingredientes;
        this.unidadProcesadora = unidadProcesadora;
        this.categoria = categoria;
    }

    public ItemMenu(String nombre, 
            double precioUnitario, 
            UnidadProcesadora unidadProcesadora, 
            Categoria categoria) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.unidadProcesadora = unidadProcesadora;
        this.categoria = categoria;
        this.ingredientes = new ArrayList<>();
    } 
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public Categoria getCategoria() {
        return categoria;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
    
    public boolean estaDisponible(){
        for(Ingrediente i:ingredientes){
            if(!i.estaDisponible()){
                return false;
            }
        }
        return true;
    }

    public boolean hayStockSuficiente() {
        for(Ingrediente i : ingredientes){
            if(i.getInsumo().getStockAct() < i.getCantidad()){
                return false;
            }
        }
        return true;
    }

    public void descontarStock() {
        for(Ingrediente i : ingredientes){
            i.getInsumo().descontar(i.getCantidad());
        }
    }
    
    public void reintegrarStock() {
        for(Ingrediente i : ingredientes){
            i.getInsumo().reintegrar(i.getCantidad());
        }
    }

}
