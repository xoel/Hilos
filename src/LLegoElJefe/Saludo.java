/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LLegoElJefe;

/**
 *
 * @author xvazqdios
 */
public class Saludo {
    int id;
    private boolean haSaludado;

    public Saludo() {
        this.haSaludado = false;
    }
    
    public synchronized void saludoEmpleado(){
        if(haSaludado){
            System.out.println("Buenos dias, soy "+id+" me voy a currar");
        }else{
            System.out.println("Soy "+id+" me voy a echar una cabezadita");
            try {
                wait();
                System.out.println("Hola jefe, soy "+id+" me pongo a currar");
            } catch (InterruptedException ex) {
                System.err.println("Interrupted Exception: "+ex);
                
            }
            
        }
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public synchronized void saludoJefe(){
        haSaludado=true;
        System.out.println("Buenos dias chavales, a ponerse acurrar");
        notifyAll();
    }
    
    
}
