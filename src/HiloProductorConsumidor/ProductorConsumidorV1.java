/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HiloProductorConsumidor;

import HiloProductorConsumidor.ProductorConsumidorV1.Velocidad;

/**
 *
 * @author xvazqdios
 */
public class ProductorConsumidorV1 {

    public static void main(String[] args) {
        Buffer dato = new Buffer();
        Productor productor = new Productor(dato, Velocidad.RAPIDA);
        Consumidor consumidor = new Consumidor(dato, Velocidad.BAJA);
        productor.start();
        consumidor.start();
    }

    public enum Velocidad {

        BAJA(100),
        MEDIO(50),
        RAPIDA(10);
        private int velocidad;

        Velocidad(int velocidad) {
            this.velocidad = velocidad;
        }

        public int getVelocidad() {
            return velocidad;
        }
    }
}


class Productor extends Thread {

    private Buffer dato;
    private Velocidad velocidad;

    public Productor(Buffer dato, Velocidad velocidad) {
        this.dato = dato;
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            dato.put(i+"");
        }
    }
    
    
}

class Consumidor extends Thread {
    private Buffer dato;
    private Velocidad velocidad;

    public Consumidor(Buffer dato, Velocidad velocidad) {
        this.dato = dato;
        this.velocidad = velocidad;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            dato.get();
        }
    }
}

class Buffer {

    private boolean disponible;
    private String dato;

    public Buffer() {
        this.disponible = false;
    }

    public synchronized void put(String dato) {
        if(disponible){
            this.dato=dato;
            disponible=false;
        }
    }
    public synchronized String get() {
        if(disponible){
            disponible=true;
            return dato;
        }else{
            return dato;
        }
    }
    
}
