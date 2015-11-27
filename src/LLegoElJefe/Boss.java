/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LLegoElJefe;


/**
 *
 * @author xvazqdios
 */
public class Boss extends Personal{
    
    public Boss(String nombre,Saludo saludo) {
        super(nombre,saludo);
    }    

    @Override
    public void aTrabajar() {
        super.aTrabajar();
        super.getSaludo().saludoJefe();
        
    }
    
}
