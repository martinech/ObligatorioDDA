/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dominio.Categoria;
import dominio.Ingrediente;
import dominio.Insumo;
import dominio.ItemMenu;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class SistemaMenu {
    
    private ArrayList<Categoria> categorias = new ArrayList();

    public void agregarCategoria(Categoria cat){
        categorias.add(cat);
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
    
}
