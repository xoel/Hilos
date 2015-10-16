/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HiloJoin;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author xvazqdios
 */
public class ProbarJoin extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Vamos por el "+i+" canuto");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            
            
        }
        
    }
    public static void main(String[] args) {
        ProbarJoin j = new ProbarJoin();
        j.start();        
        System.out.println("Comenzamos a trabajar");
        for (int i = 0; i < 10; i++) {
            System.out.println("calada calada");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
        try {
            j.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("You are Hight like a hell");
        
    }
    
}
