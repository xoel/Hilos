/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioTocToc;

/**
 *
 * @author xvazqdios
 */
public class HiloTocToc extends Thread {

    private int interrumpido = 0, interrupciones = 3;

    public HiloTocToc(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("Comienza el Hilo");
        for (int i = 0; i < 100; i++) {
            if (Thread.interrupted()) {
                if (interrumpido < interrupciones) {
                    System.out.println(interrumpido+"ª Interrupcion, ni caso.");
                    interrumpido++;
                }else{
                    System.out.println("Qué pesados!. Tendré que parar de trabajar e ir ver quién es.");
                    return;
                }
            } else {
                System.out.println(i + " TocToc");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
