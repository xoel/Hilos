/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoversTalking;



/**
 *
 * @author xvazqdios
 */
public class WriteAndTalk {
    boolean canTalk=true;
    public synchronized void talk() {
        while (!canTalk){ 
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Wait interrumpido: "+ex);
            }
        }
        //debemos leer, despertar con notify y poner a true
        
        canTalk = true;
        notify();
    }
    
}
