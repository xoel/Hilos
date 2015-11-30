/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parking;



/**
 *
 * @author xvazqdios
 */
public class Aparcamiento {
    private final int numPlazas=10;
    Vehiculo[] listaVehiculos;

    public Aparcamiento() {
         listaVehiculos = new Vehiculo[numPlazas];
    }

    public synchronized void aparcar(Vehiculo veh) {
        while(!plazasLibres()){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Interrumpida la espera mientras no hay plazas: "+ex);
            }
        }
        aparcamos(veh);
        
    }

    public synchronized void salir(Vehiculo veh) {
        salimos(veh);
        notify();
    }
    
    public boolean plazasLibres(){
        for (int i = 0; i < listaVehiculos.length; i++) {
            if(listaVehiculos[i]==null){
                return true;
            }            
        }
        return false;
    }
    //Estos metodos deberian estar sincronizados si intentamos llamarlos desde otro sitio
    //Si solo son llamados desde el syncroniced no deberia tener problema
    private void aparcamos(Vehiculo veh){
        for (int i = 0; i < listaVehiculos.length; i++) {
            if(listaVehiculos[i]==null){
                System.out.println(veh.getName()+": Aparcaooo en la plaza: "+i);
                listaVehiculos[i]=veh;
                return;
            }
        }
        System.err.println("No se ha podido aparcar un dominguero se m'adelantao");
    }

    private void salimos(Vehiculo veh){
        for (int i = 0; i < listaVehiculos.length; i++) {
            if(listaVehiculos[i]==veh){
                System.out.println(veh.getName()+": Me doy el piro vampiro de la plaza: "+i);
                listaVehiculos[i]=null;
            }
        }
        
    }
    
    
    
    
    
    
}
