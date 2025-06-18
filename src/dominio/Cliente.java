/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author marti
 */
public class Cliente extends Usuario{
    
    private Dispositivo dispositivo;
    
    private String id;

    public Cliente(String id, String password, String nombreCompleto) {
        super(password, nombreCompleto);
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    public boolean validar(){
        if(super.validar() && id!=null && !id.isBlank()){
            return true;
        }
        return false;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    
    @Override
    public boolean verificarCredenciales(String id, String password) {
        return this.id.equals(id) && this.password.equals(password);
    }

    //metodos polimorficos por defecto para un cliente comun
    public double calcularDescuento(Servicio servicio){
        return 0;
    }
    
    public String descripcionBeneficio(Servicio servicio){
        return "Sin beneficio.";
    }
}
