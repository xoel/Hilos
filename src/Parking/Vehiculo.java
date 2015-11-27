/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parking;

import java.util.Random;
/**
 *
 * @author xvazqdios
 */
public class Vehiculo extends Thread{
    private String nombre;
    private Aparcamiento aparcamiento;

    public Vehiculo(String nombre,Aparcamiento aparcamiento) {
        super(nombre);
        this.aparcamiento=aparcamiento;
    }

    @Override
    public void run() {
        //try {
            //wait(new Random().nextInt(250));            
            aparcamiento.aparcar(this);
            try {
                wait(new Random().nextInt(500));
            } catch (InterruptedException ex) {
                System.err.println("Wait interrumpido mientras estaba aparcao:"+ex);
            }
            aparcamiento.salir(this);
//        } catch (InterruptedException ex) {
//            System.err.println("Wait interrempido antes de buscar aparcamiento");
//        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    
    
}
