
package logica;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.EstadoDispositivo;
import excepciones.PollomorfismoException;
import java.util.ArrayList;


public class SistemaDispositivos {
    
    private ArrayList<Dispositivo> dispositivos = new ArrayList();
    
    void agregarDispositivo() {
        dispositivos.add(new Dispositivo());
    }

    void asignarDispositivoDisponible(Cliente cliente) throws PollomorfismoException {
        if(cliente != null){
            if(cliente.getDispositivo() != null) throw new PollomorfismoException("Ud. ya está identificado en otro dispositivo.");
            for(Dispositivo d:dispositivos){
            if (d.getEstado() == EstadoDispositivo.DISPONIBLE){
                cliente.setDispositivo(d);
                d.setEstado(EstadoDispositivo.OCUPADO);
                return;
            }
        }
        throw new PollomorfismoException("No quedan dispositivos disponibles");
        }
    }

    public boolean estaClienteActivo(Cliente cliente){
        for(Dispositivo d : dispositivos){
            if(d.getEstado() == EstadoDispositivo.OCUPADO && cliente.equals(d.getCliente())){
            return true;
            }
        }
        return false;
    }
}
