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
public class UnidadProcesadora {
    
    private String nombre;
    
    private List<Gestor> gestores = new ArrayList<>();
    
    private List<ItemMenu> items = new ArrayList();

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    public List<Gestor> getGestores() {
        return gestores;
    }

    public List<ItemMenu> getItems() {
        return items;
    }
    
    
}
