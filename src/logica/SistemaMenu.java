
package logica;

import dominio.Categoria;
import dominio.Ingrediente;
import dominio.Insumo;
import dominio.ItemMenu;
import java.util.ArrayList;


public class SistemaMenu {
    
    private ArrayList<Categoria> categorias = new ArrayList();

    public void agregarCategoria(Categoria cat){
        categorias.add(cat);
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
    
}
