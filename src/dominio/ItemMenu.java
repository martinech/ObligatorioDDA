/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ItemMenu {
    
    private String nombre;
    
    private double precio;
    
    private ArrayList<Ingrediente> ingredientes;
    
    private UnidadProcesadora unidadProcesadora;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
    
}
