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
public class Categoria {
    
    private String nombre;
    
    private ArrayList<ItemMenu> itemsMenu = new ArrayList<>();

    public Categoria(String nombre, ArrayList<ItemMenu> itemsMenu) {
        this.nombre = nombre;
        this.itemsMenu = itemsMenu;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<ItemMenu> getItemsMenu() {
        return itemsMenu;
    }  

}
