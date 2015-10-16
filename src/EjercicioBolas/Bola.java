/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioBolas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xvazqdios
 */
public class Bola extends Thread {

    int x,y,alto,ancho,velocidad;
    Color color;

    public Bola(int x, int y, int alto, int ancho, int velocidad, Color color) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;
        this.velocidad = velocidad;
        this.color = color;
    }
    
    public void moveBall() {
        x = x + 1;
        y = y + 1;
    }

    @Override
    public void run() {
        moveBall();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void pintarBola(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, alto, ancho);
        
    }
    
    
}
