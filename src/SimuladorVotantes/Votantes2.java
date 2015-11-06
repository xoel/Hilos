/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorVotantes;

/**
 *
 * @author xvazqdios
 */
public class Votantes2 extends Thread {

    private final int maxWaitTime = 500;
    private int timeWait;
    private int maxPartidos;

    public Votantes2(String nombre,int maxPartidos) {
        super(nombre);
        this.maxPartidos=maxPartidos;
    }

    @Override
    public void run() {
        try {
            timeWait = numAleatorio(maxWaitTime);
            Thread.sleep(timeWait);
                //le pasamos menos uno ya que en el array las pos van de 0 a 4
             ColegioElectoral2.urna[numAleatorio(maxPartidos)-1].votar();
        } catch (InterruptedException ex) {
            
            System.out.println("Interrumpido");
        }
    }

    public int numAleatorio(int max) {        
        System.out.println("Hemos votado: " + timeWait);
        return (int) Math.floor(Math.random() * (max - 1 + 1) + 1);
        
    }
}
