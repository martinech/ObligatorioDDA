
package obligatorio;

import dominio.Categoria;
import dominio.Cliente;
import dominio.DeLaCasa;
import dominio.Dispositivo;
import dominio.EstadoDispositivo;
import dominio.Frecuente;
import logica.Fachada;
import dominio.Gestor;
import dominio.Ingrediente;
import dominio.ItemMenu;
import dominio.UnidadProcesadora;
import dominio.Insumo;
import dominio.Preferencial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class DatosPrueba {
    public static List<Dispositivo> dispositivos = new ArrayList<>();
    public static List<UnidadProcesadora> unidadesProcesadoras = new ArrayList<>();
    public static List<ItemMenu> items = new ArrayList<>();
    public static List<Insumo> insumos = new ArrayList<>();
    
    
    public static void precargar(){
        //insumos 
        Insumo papa        = new Insumo("Papa",          20,  30);
        Insumo carneVaca   = new Insumo("Carne vacuna",   8,  15);
        Insumo huevo       = new Insumo("Huevo",         30,  60);
        Insumo panRallado  = new Insumo("Pan rallado",   10,  20);
        Insumo aceite      = new Insumo("Aceite",        15,  30);
        Insumo arrozSushi  = new Insumo("Arroz de sushi",12,  20);
        Insumo salmon      = new Insumo("Salmón fresco",  6,  10);
        Insumo nori        = new Insumo("Alga nori",     40,  80);
        Insumo gin         = new Insumo("Gin",           10,  15);
        Insumo aguaTonica  = new Insumo("Agua tónica",   20,  25);
        Insumo limon       = new Insumo("Limón",         25,  30);
        Insumo cafeMolido  = new Insumo("Café molido",   15,  30);
        Insumo hielo       = new Insumo("Hielo",         50, 200);
        Insumo aguaMineral = new Insumo("Agua mineral",  60, 100);

        insumos.addAll(List.of(papa, carneVaca, huevo, panRallado, aceite,
                               arrozSushi, salmon, nori, gin, aguaTonica,
                               limon, cafeMolido, hielo, aguaMineral));
        
        //unidades procesadoras
       UnidadProcesadora cocina = new UnidadProcesadora("Cocina");
       UnidadProcesadora bar = new UnidadProcesadora("Bar");
       UnidadProcesadora barraSushi = new UnidadProcesadora("BarraSushi");
       
       //Gestores
       Gestor g1 = new Gestor("ana", "coc123", "Ana Lopez", cocina);
       Fachada.getInstancia().agregarGestor("ana", "coc123", "Ana Lopez", cocina);
       cocina.getGestores().add(g1);
       Gestor g2 = new Gestor("julian", "bar123", "Julian Perez", bar);
       Fachada.getInstancia().agregarGestor("julian", "bar123", "Julian Perez", bar);
       bar.getGestores().add(g2);
       Gestor g3 = new Gestor("mateo", "sush123", "Mateo Hernandez", barraSushi);
       Fachada.getInstancia().agregarGestor("mateo", "sush123", "Mateo Hernandez", barraSushi);
       barraSushi.getGestores().add(g3);
       Gestor g4 = new Gestor("maria", "coc123", "María González", cocina);
       Fachada.getInstancia().agregarGestor("maria", "coc123", "María González", cocina);
       cocina.getGestores().add(g4);
       
       //categorias
       Categoria entrada = new Categoria("Entrada");
       Categoria principal = new Categoria("Plato Principal");
       Categoria bebida = new Categoria("Bebida");
       Fachada.getInstancia().agregarCategoria(entrada);
       Fachada.getInstancia().agregarCategoria(principal);
       Fachada.getInstancia().agregarCategoria(bebida);
       
       //Items e ingredientes
       // 1) Milanesa con papas fritas
        ItemMenu milanesa = new ItemMenu("Milanesa con fritas", 580.0, cocina, principal);
        milanesa.getIngredientes().add(new Ingrediente(carneVaca,  1)); // 1 unidad
        milanesa.getIngredientes().add(new Ingrediente(huevo,      1));
        milanesa.getIngredientes().add(new Ingrediente(panRallado, 2));
        milanesa.getIngredientes().add(new Ingrediente(aceite,     1));
        milanesa.getIngredientes().add(new Ingrediente(papa,       3));
        items.add(milanesa);
        principal.getItemsMenu().add(milanesa);
        cocina.getItems().add(milanesa);
       
       // 3) Gin Tonic
        ItemMenu ginTonic = new ItemMenu("Gin Tonic", 310.0, bar, bebida);
        ginTonic.getIngredientes().add(new Ingrediente(gin,        1));
        ginTonic.getIngredientes().add(new Ingrediente(aguaTonica, 1));
        ginTonic.getIngredientes().add(new Ingrediente(limon,      1));
        ginTonic.getIngredientes().add(new Ingrediente(hielo,      3));
        items.add(ginTonic);
        bebida.getItemsMenu().add(ginTonic);
        bar.getItems().add(ginTonic);
       
       // 2) Nigiri de salmón
        ItemMenu nigiri = new ItemMenu("Nigiri de salmón", 340.0, barraSushi, entrada);
        nigiri.getIngredientes().add(new Ingrediente(arrozSushi, 1));
        nigiri.getIngredientes().add(new Ingrediente(salmon,     1));
        nigiri.getIngredientes().add(new Ingrediente(nori,       1));
        items.add(nigiri);
        entrada.getItemsMenu().add(nigiri);
        barraSushi.getItems().add(nigiri);
       
       // 4) Café expreso
        ItemMenu cafe = new ItemMenu("Café expreso", 140.0, bar, bebida);
        cafe.getIngredientes().add(new Ingrediente(cafeMolido, 1));
        cafe.getIngredientes().add(new Ingrediente(aguaMineral,1));
        items.add(cafe);
        bebida.getItemsMenu().add(cafe);
        bar.getItems().add(cafe);

       // 5) Agua mineral
        ItemMenu agua = new ItemMenu("Agua mineral", 110.0, bar, bebida);
        agua.getIngredientes().add(new Ingrediente(aguaMineral, 1));
        agua.getIngredientes().add(new Ingrediente(hielo,       2));
        items.add(agua);
        bebida.getItemsMenu().add(agua);
        bar.getItems().add(agua);
        
        // 6) Papas fritas (comparte 'papa' y 'aceite' con la milanesa)
        ItemMenu papasFritas = new ItemMenu("Papas fritas", 250.0, cocina, entrada);
        papasFritas.getIngredientes().add(new Ingrediente(papa,   4));
        papasFritas.getIngredientes().add(new Ingrediente(aceite, 1));
        items.add(papasFritas);             
        entrada.getItemsMenu().add(papasFritas); 
        cocina.getItems().add(papasFritas);

       
       //clientes
       Cliente c1= new Cliente("1","c1pass", "Carlos Daniel");
       Cliente c2= new Frecuente("2","c2pass", "Roberto Carlos");
       Cliente c3= new Preferencial("3","c3pass", "Andres Roberto");
       Cliente c4 = new DeLaCasa("4", "c4pass", "Federico Alberti");
       
       Fachada.getInstancia().agregarCliente(c1);   // Cliente común
       Fachada.getInstancia().agregarCliente(c2);   // Frecuente
       Fachada.getInstancia().agregarCliente(c3);   // Preferencial
       Fachada.getInstancia().agregarCliente(c4);   // DeLaCasa
       
       // dispositivos
       
       for(int i = 1; i<=10; i++){
           Fachada.getInstancia().agregarDispositivo();//dispositivo Disponible por defecto
       }
    }    
}

