package HiloProductorConsumidor;

import java.util.Random;

public class Buffer {

    private String str;
    private boolean disponible = false;

    public synchronized String get() throws InterruptedException {
        while (!disponible) 
            wait();
        
        disponible = false;
        System.out.println("GET " + str);
        notify();
        return str;
    }

    public synchronized void put(String str) throws InterruptedException {
        while (disponible) 
            wait();
        this.str = str;
        System.out.println("PUT " + str);
        disponible = true;
        notify();
    }
}

enum VelocidadAcceso {

    LENTO(1000), NORMAL(500), RAPIDO(100), INMEDIATO(0), ALEATORIO(-1);
    private int milisegundos;

    VelocidadAcceso(int milisegundos) {
        this.milisegundos = milisegundos;
    }

    public int getMilisegundos() {
        if (milisegundos == -1)
            return new Random().nextInt(LENTO.getMilisegundos());
        return milisegundos;
    }
};
