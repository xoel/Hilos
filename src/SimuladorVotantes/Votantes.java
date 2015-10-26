/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorVotantes;



/**
 *
 * @author xvazqdios
 */
public class Votantes extends Thread {

    private final int maxWaitTime = 500;
    private final int maxPartidos =5;
    private int timeWait;
    
    public Votantes(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        try {
            timeWait = (int) Math.floor(Math.random()*(maxWaitTime-1+1)+1);
            Thread.sleep(timeWait);
            
        } catch (InterruptedException ex) {
            System.out.println("Interrumpido");
        }
    }

    public int votar(){
        System.out.println("Hemos votado: "+timeWait);
        return (int) Math.floor(Math.random()*(maxPartidos-1+1)+1);
    }
}
