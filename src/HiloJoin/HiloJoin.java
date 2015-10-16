/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HiloJoin;

/**
 *
 * @author xvazqdios
 */
public class HiloJoin extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            System.out.println("Hilo trabajando");
        }
    }

    public static void main(String[] args) {
        HiloJoin t = new HiloJoin();
        t.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("Voy haciendo otras cosas por aquí ... ");
            } catch (InterruptedException ex) {
            }
        }
        try {
            t.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("Trabajo importante asumiendo que el hilo acabó");
    }
}
