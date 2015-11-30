/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parking;

/**
 *
 * @author xvazqdios
 */
public class Main {
    public static void main(String[] args) {
        
        Aparcamiento parkingLola = new Aparcamiento();
        for (int i = 0; i < 25; i++) {
            Vehiculo vehiculo = new Vehiculo(String.valueOf(i), parkingLola);
            vehiculo.start();
        }
        
    }
    
}
