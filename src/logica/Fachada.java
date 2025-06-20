
package logica;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Gestor;
import dominio.Pedido;
import dominio.Servicio;
import dominio.UnidadProcesadora;
import excepciones.PollomorfismoException;
import java.util.ArrayList;
import java.util.List;
import observador.Observable;
import observador.Observador;

public class Fachada extends Observable implements Observador{


    public enum eventos {loginCliente, loginGestor, nuevoPedido, logoutGestor};
    
    private SistemaAcceso sAcceso = new SistemaAcceso();
    
    private SistemaDispositivos sDispositivos = new SistemaDispositivos();
    
    private SistemaMenu sMenu = new SistemaMenu();
    
    private SistemaPedidos sPedido = new SistemaPedidos();
    
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
    }

    public SistemaAcceso getsAcceso() {
        return sAcceso;
    }
    
    public void agregarCliente(String numCliente, String password, String nombreCompleto){
        sAcceso.agregarCliente(numCliente, password, nombreCompleto);
    }
    //sobrecarga de los clientes por tipo
    public void agregarCliente(Cliente c) {          
    sAcceso.agregarCliente(c);
}
    
    public void agregarGestor(String password, String nombreCompleto, String nombreUsuario, UnidadProcesadora unidadProcesadora){
        sAcceso.agregarGestor(password, nombreCompleto, nombreUsuario, unidadProcesadora);
    }    
    
    public void agregarDispositivo(){
        sDispositivos.agregarDispositivo();
    }
    
    public void agregarCategoria(Categoria cat){
        sMenu.agregarCategoria(cat);
    }
    
    //movi logica para subsistema. si cliente es null toma como que las credenciales no son correctas(en la vista) falta el caso de que el usuario ya esta logueado
    //no entiendo con nuestro modelo como un cliente se puede loguear en un dispositivo que ya esta asignado a otro cliente
   
    public Cliente loginCliente(String id, String password) throws PollomorfismoException{
        return sAcceso.loginCliente(id, password);
    }
    
    public Gestor loginGestor(String nomUsuario, String password) throws PollomorfismoException{
        return sAcceso.loginGestor(nomUsuario,password);
    }
    
    
     public boolean logoutGestor(Gestor g) throws PollomorfismoException{
        return sAcceso.logoutGestor(g);
     }
    
    public void asignarDispositivoDisponible(Cliente cliente) throws PollomorfismoException{
        sDispositivos.asignarDispositivoDisponible(cliente);
    }
    
    public Servicio comenzarServicio(Cliente cliente){
        Servicio s = sPedido.comenzarServicio(cliente);
        s.agregarObservador(this);
        return s;
    }
    
   /* public void agregarPedidoAServicioCliente(Servicio servicio, Pedido pedido){
        sPedido.agregarPedidoAServicioCliente(servicio, pedido);
    }*/
    
    public ArrayList<Categoria> getCategorias(){
        return sMenu.getCategorias();
    }
    
    public ArrayList<Cliente> getClientes(){
        return sAcceso.getClientes();
    }
    
    public ArrayList<Gestor> getGestores(){
        return sAcceso.getGestores();
    }
    
    public ArrayList<Pedido> getPedidosDelServicio(Cliente cliente){
        return sPedido.getPedidosDelServicio(cliente);
    }
    
    public boolean clienteYaIdentificado(Cliente cliente) {
        return sDispositivos.estaClienteActivo(cliente);
    }
    
    public List<Pedido> getPedidosTomadosPorGestor(Gestor g){
        return sPedido.getPedidosTomadosPorGestor(g);
    }
    
    public List<Pedido> getPedidosPendientesPorUnidad(UnidadProcesadora up){
        return sPedido.getPedidosPendientesPorUnidad(up);
    }

    public void asignarPedidosAGestor(Pedido ped, Gestor ges) throws PollomorfismoException{
        sPedido.asignarPedidosAGestor(ped, ges);
    }
    
    
     public void finalizarPedido(Pedido ped, Gestor ges) throws PollomorfismoException{
         sPedido.finalizarPedido(ped, ges);
     }
     
     public void entregarPedido(Pedido ped, Gestor ges) throws PollomorfismoException{
         sPedido.entregarPedido(ped, ges);
     }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        avisar(evento);
    }
}
