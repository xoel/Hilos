/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LLegoElJefe;

/**
 *SIMULACION DE 4 EMPLEADOS Y  UN JEFE, MIENTRAS NO LLEGA EL JEFE LOS EMPLEADOS DUERMEN
 * CUANDO ESTE LLLEGA LOS DESPIERTA, SI LLEGA ALGUN EMPLEADO MAS TARDE QUE EL JEFE SE PONE A TRABAJAR
 * @author xvazqdios
 */
public class Principal {
    public static void main(String[] args) {
        Saludo saludo = new Saludo();
        for (int i = 0; i < 10; i++) {
            saludo.setId(i);
            if(i==3){                
                Boss boss = new Boss(String.valueOf(i),saludo);
                boss.start();                
            }else{
                Empleado emp = new Empleado(String.valueOf(i),saludo);
                emp.start();
            }
            
            
        }
        
    }
    
}
