/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas;

public class BolaDisparo extends Bola {

    public BolaDisparo(Velocidad velocidad) {
        super(velocidad);
    }

    @Override
    public void comportamiento() {
        x += 4;
    }

    @Override
    public boolean vive() {
        return (x < tablero.getWidth());
    }
}
