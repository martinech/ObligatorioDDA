package vistas;

import dominio.Pedido;
import java.util.List;

public interface VistaGestor {
    public void mostrarEncabezado(String nomGestor, String unidadProcesadora);
    public void mostrarPedidosPendientes(List<Pedido> pendientes);
    public void mostrarPedidosTomados(List<Pedido> tomados);
    public void mostrarError(String mensaje);
}
