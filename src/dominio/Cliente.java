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
    
    private int id;

    public Cliente(int id, String password, String nombreCompleto) {
        super(password, nombreCompleto);
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public boolean validar(){
        if(super.validar() && id>0){
            return true;
        }
        return false;
    }
    
    
}
