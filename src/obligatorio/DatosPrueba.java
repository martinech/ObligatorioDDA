/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.EstadoDispositivo;
import logica.Fachada;
import dominio.Gestor;
import dominio.Ingrediente;
import dominio.ItemMenu;
import dominio.UnidadProcesadora;
import dominio.Insumo;
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
        Insumo aceituna = new Insumo("Aceituna", 10 , 50);
        insumos.add(aceituna);
        Insumo papa = new Insumo("Papa", 20 , 100);
        insumos.add(papa);
        Insumo carne = new Insumo("Carne", 5 , 30);
        insumos.add(carne);
        Insumo hielo = new Insumo("Hielo", 50 , 200);
        insumos.add(hielo);
        
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
       
       //categorias
       Categoria entrada = new Categoria("Entrada");
       Categoria principal = new Categoria("Plato Principal");
       Categoria bebida = new Categoria("Bebida");
       Fachada.getInstancia().agregarCategoria(entrada);
       Fachada.getInstancia().agregarCategoria(principal);
       Fachada.getInstancia().agregarCategoria(bebida);
       
       //Items e ingredientes
       ItemMenu milanesa = new ItemMenu("Mila con fritas", 450.0, cocina, principal);
       milanesa.getIngredientes().add(new Ingrediente(papa,3,milanesa));
       items.add(milanesa);
       principal.getItemsMenu().add(milanesa);
       cocina.getItems().add(milanesa);
       
       ItemMenu ginTonic = new ItemMenu("Gin Tonic", 280.0, bar, bebida);
       ginTonic.getIngredientes().add(new Ingrediente(hielo, 5, ginTonic));
       items.add(ginTonic);
       bebida.getItemsMenu().add(ginTonic);
       bar.getItems().add(ginTonic);
       
       ItemMenu nigiri = new ItemMenu("Nigiri", 320.0, barraSushi, entrada);
       nigiri.getIngredientes().add(new Ingrediente(carne, 2 ,nigiri));
       items.add(nigiri);
       entrada.getItemsMenu().add(nigiri);
       barraSushi.getItems().add(nigiri);
       
       //clientes
       Cliente c1= new Cliente("1","c1pass", "Carlos Diaz");
       Cliente c2= new Cliente("2","c2pass", "Roberto Carlos");
       Cliente c3= new Cliente("3","c3pass", "Andres Roberto");
       Fachada.getInstancia().agregarCliente("1", "c1pass", "Carlos Diaz");
       Fachada.getInstancia().agregarCliente("2", "c2pass", "Roberto Carlos");
       Fachada.getInstancia().agregarCliente("3", "c3pass", "Andres Roberto");
       
       // dispositivos
       
       for(int i = 1; i<=10; i++){
           Fachada.getInstancia().agregarDispositivo();//dispositivo Disponible por defecto
       }
       
        
        
    
    }
    
    
    
    
    
    
    
    
    
}

