/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parking;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author xvazqdios
 */
public class Vehiculo extends Thread{
    private Aparcamiento aparcamiento;

    public Vehiculo(String nombre,Aparcamiento aparcamiento) {
        super(nombre);
        this.aparcamiento=aparcamiento;
    }

    @Override
    public void run() {      
            aparcamiento.aparcar(this);
        try {
            sleep(new Random().nextInt(500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
            aparcamiento.salir(this);

    }

    
    
    
    
    
    
    
    
}
