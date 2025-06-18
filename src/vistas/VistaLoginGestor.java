package vistas;
import dominio.Gestor;

public interface VistaLoginGestor {

    public void mostrarError(String message);

    public void loginGestorExitoso(Gestor gestor);
    
}
