/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obligatorio;

import IU.VentanaCliente;
import IU.LoginGestor;
import IU.MenuDesarrollo;
import dominio.EstadoDispositivo;
import dominio.ItemMenu;
import java.util.stream.Collectors;
import logica.Fachada;

/**
 *
 * @author marti
 */
public class Obligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DatosPrueba.precargar();
        
          // 2) Verificar tamaños
        System.out.println("Clientes cargados:     " + Fachada.getInstancia().getClientes().size());
        System.out.println("Dispositivos cargados: " + DatosPrueba.dispositivos.size());
        System.out.println("Unidades cargadas:     " + DatosPrueba.unidadesProcesadoras.size());
        System.out.println("Gestores cargados:     " + Fachada.getInstancia().getGestores().size());
        System.out.println("Categorías cargadas:   " + Fachada.getInstancia().getCategorias().size());
        System.out.println("Items cargados:        " + DatosPrueba.items.size());
        System.out.println("Insumos cargados:      " + DatosPrueba.insumos.size());
        
        
        System.out.println("\n-- Primeros ítems y sus unidades procesadoras --");
        DatosPrueba.items.stream().limit(3)
            .forEach(item -> System.out.printf("- %s (%s)%n",
                item.getNombre(),
                item.getUnidadProcesadora().getNombre()
            ));
        
        System.out.println("\n-- Dispositivos disponibles --");
        long libres = DatosPrueba.dispositivos.stream()
            .filter(d -> d.getEstado() == EstadoDispositivo.DISPONIBLE)
            .count();
        System.out.println("Cantidad: " + libres);
        
        
        ItemMenu muestra = DatosPrueba.items.get(0);
        System.out.printf("%nIngredientes de '%s': %s%n",
            muestra.getNombre(),
            muestra.getIngredientes().stream()
                .map(ing -> ing.getCantidad() + " x " + ing.getInsumo().getNombre())
                .collect(Collectors.joining(", "))
        );

        new MenuDesarrollo().setVisible(true);
        
    }
}
