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
    
    @Override
    public boolean verificarCredenciales(String id, String password) {
        if(this.id == id && this.password==password) {
            return true;
        }
        return false;
    }

}
