/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LLegoElJefe;

/**
 *
 * @author xvazqdios
 */
public abstract class Personal extends Thread{
    private String nombre;
    private Saludo saludo;
    
    public Personal(String nombre,Saludo saludo) {
        this.nombre = nombre; 
        this.saludo = saludo;
    }

    @Override
    public void run() {
        aTrabajar();
    }

    public String getNombre() {
        return nombre;
    }

    public Saludo getSaludo() {
        return saludo;
    }
    
    
    public void aTrabajar(){
        System.out.print("Soy "+nombre+": ");
    }
    
     
    
}
