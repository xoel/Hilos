/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LLegoElJefe;

import java.util.Random;

/**
 *SIMULACION DE X EMPLEADOS Y  UN JEFE, MIENTRAS NO LLEGA EL JEFE LOS EMPLEADOS DUERMEN
 * CUANDO ESTE LLLEGA LOS DESPIERTA, SI LLEGA ALGUN EMPLEADO MAS TARDE QUE EL JEFE SE PONE A TRABAJAR
 * @author xvazqdios
 */
public class Principal {
    private static final int NUM_EMPLEADOS = 6;
    private static final int ENTRA_JEFE = new Random().nextInt(NUM_EMPLEADOS);
    public static void main(String[] args) {
        Saludo saludo = new Saludo();
        for (int i = 0; i < NUM_EMPLEADOS; i++) {
            if(i==ENTRA_JEFE){                
               new Boss("Jefe",saludo).start();               
            }else{
                new Empleado(String.valueOf(i),saludo).start();
               
            }
            
            
        }
        
    }
    
}
