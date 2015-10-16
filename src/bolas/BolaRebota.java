/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas;

public class BolaRebota extends Bola {

    int sentido;

    public BolaRebota(Velocidad velocidad) {
        super(velocidad);
        sentido = 1;
    }

    @Override
    public void comportamiento() {
        x += (4 * sentido);
        if(x<0) {
            sentido = 1;
             //x=0; // queremos q vuelvan con el borde?
        }
        else if (x>tablero.getWidth()) {
            sentido=-1;
             //x = tablero.getWidth(); // queremos que vuelvan con el borde?
        }
    }

    @Override
    public boolean vive() {
        return true;
    }
}
