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
    private boolean haSaludado;

    public Saludo() {
        this.haSaludado = false;
    }
    
    public synchronized void saludoEmpleado(String nombre){
        if(haSaludado){
            //si el jefe ya ha saludado nos ponemos a currar
            System.out.println("Buenos dias, me voy a currar");
        }else{
            //si no ha llegado nos ponemos a dormir hasta que lelga
            System.out.println("Me voy a echar una cabezadita");
            try {
                wait();
                System.out.println("Soy "+nombre+": Bienvenido Jefe, ahora mismo  me pongo a currar");
            } catch (InterruptedException ex) {
                System.err.println("Interrupted Exception: "+ex);
                
            }
            
        }
    }
    
    public synchronized void saludoJefe(){
        //en cuanto llega el jefe ponemos la variable a true para los que lleguen
        //y "despertamos" a los que estaban sobando(wait) con un notifyAll
        haSaludado=true;
        System.out.println("Buenos dias chavales, a ponerse acurrar");
        notifyAll();
    }
    
    
}
