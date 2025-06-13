/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dominio.Cliente;
import dominio.Gestor;
import dominio.UnidadProcesadora;
import dominio.Usuario;
import excepciones.PollomorfismoException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class SistemaAcceso {
    
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Gestor> gestores = new ArrayList();

    
    public void agregarCliente(String numCliente, String password, String nombreCompleto){
        Cliente cliente = new Cliente(numCliente, password, nombreCompleto);
        clientes.add(cliente);
    }
    
    public void agregarGestor(String password, String nombreCompleto, String nombreUsuario, UnidadProcesadora unidadProcesadora){
        Gestor gestor = new Gestor(password, nombreCompleto, nombreUsuario, unidadProcesadora);
        gestores.add(gestor);
    }
    
    public Cliente loginCliente(String id, String password) throws PollomorfismoException {
        Cliente unCliente = (Cliente)this.buscarUsuario(id, password, clientes);
        Fachada.getInstancia().asignarDispositivoDisponible(unCliente);
        Fachada.getInstancia().avisar(Fachada.eventos.loginCliente);
        return unCliente;
    }
    
    public Gestor loginGestor (String nomUsuario, String password) throws PollomorfismoException {
        Gestor unGestor = (Gestor)this.buscarUsuario(nomUsuario, password, gestores);        
        return unGestor;
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
