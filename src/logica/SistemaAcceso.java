
package logica;

import dominio.Cliente;
import dominio.Gestor;
import dominio.UnidadProcesadora;
import dominio.Usuario;
import excepciones.PollomorfismoException;
import java.util.ArrayList;



public class SistemaAcceso {
    
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Gestor> gestores = new ArrayList();
    
    private ArrayList<Gestor> gestoresActivos = new ArrayList<>();

    
    public void agregarCliente(String numCliente, String password, String nombreCompleto){
        Cliente cliente = new Cliente(numCliente, password, nombreCompleto);
        clientes.add(cliente);
    }
    //sobrecarga de clientes para los tipos diferentes
    public void agregarCliente(Cliente c) {
    clientes.add(c);          
}
    
    public void agregarGestor(String password, String nombreCompleto, String nombreUsuario, UnidadProcesadora unidadProcesadora){
        Gestor gestor = new Gestor(password, nombreCompleto, nombreUsuario, unidadProcesadora);
        gestores.add(gestor);
    }
    
    public Cliente loginCliente(String id, String password) throws PollomorfismoException {
        Cliente unCliente = (Cliente)this.buscarUsuario(id, password, clientes);
        if(unCliente == null){
            throw new PollomorfismoException("Credenciales incorrectas.");
        }
        
        //verificamos si esta logueado
        if(Fachada.getInstancia().clienteYaIdentificado(unCliente)){
            throw new PollomorfismoException("Ud. ya esta identificado en otro dispositivo.");
        }
        
        Fachada.getInstancia().asignarDispositivoDisponible(unCliente);
        Fachada.getInstancia().avisar(Fachada.eventos.loginCliente);
        return unCliente;
    }
    
    public Gestor loginGestor (String nomUsuario, String password) throws PollomorfismoException {
        Gestor unGestor = (Gestor)this.buscarUsuario(nomUsuario, password, gestores);  
        if(unGestor == null){
            throw new PollomorfismoException("Credenciales incorrectas.");
        }
        
        //sesion ya esta activa? 
        if(gestoresActivos.contains(unGestor)){
            throw new PollomorfismoException("Acceso denegado. El usuario ya está logueado.");
        }
        
        //si no esta logueado lo agrego al array de activos
        gestoresActivos.add(unGestor);
        return unGestor;
    }
    
    public void logoutGestor(Gestor g){
        gestoresActivos.remove(g);
    }
    
    private Usuario buscarUsuario(String id, String psw, ArrayList lista){
        Usuario usuario;
        for(Object obj:lista){
            usuario = (Usuario)obj;           
            if(usuario.verificarCredenciales(id, psw)){              
                return usuario;
            }
        }
        return null;   
   }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

}
