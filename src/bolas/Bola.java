/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class Bola extends Thread {

    public enum Velocidad { LENTO, NORMAL, RAPIDO };
    
    static protected Tablero tablero = Tablero.getInstance();
    static private final int anchura = 10, altura = 10;
    protected int x, y;
    private int retardo;
    private Color color;
    boolean volando;

    public Bola(Velocidad velocidad) {
        x = 0;
        y = (new Random()).nextInt(tablero.getHeight());
        volando = true;

        switch (velocidad) {
            case LENTO:
                retardo = 40;
                color = Color.green;
                break;
            case NORMAL:
                retardo = 20;
                color = Color.yellow;
                break;
            case RAPIDO:
                retardo = 5;
                color = Color.red;
                break;
        }
    }

    public void pinta(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, Bola.anchura, Bola.altura);
    }

    public void fin() {
        volando = false;
    }

    abstract public void comportamiento();
    abstract public boolean vive();

    @Override
    public void run() {
        while (volando) {
            try {
                Thread.sleep(retardo);
            } catch (InterruptedException ie) {
                fin();
            }
            comportamiento();
            tablero.repaint();
            if (Thread.interrupted()) 
                 fin();
        }
    }
}
