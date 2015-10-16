/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioTocToc;

/**
 *
 * @author xvazqdios
 */
public class Interrupcion extends Thread {

    private static final String[] toctoc = new String[]{"Primera", "Segunda", "Tercera"};

    @Override
    public void run() {
        int num_toc_toc = 0;
        int i = 0;
        System.out.println("Comienza el hilo trabajador");
        while (num_toc_toc <= toctoc.length) {
            System.out.println(i++ + "");
            if (Thread.interrupted()) {
                if (num_toc_toc < toctoc.length) {
                    System.out.println(toctoc[num_toc_toc] + " interrupción. Ni caso,estoy trabajando");
                } else {
                    System.out.println("Qué pesados!. Tendré que parar de trabajar e ir ver quién es.");
                }
                num_toc_toc++;
            }
        }
    }

    public static void main(String[] args) {
        Interrupcion hilo = new Interrupcion();
        hilo.start();
        int num_toc_toc = 0;
        while (num_toc_toc <= toctoc.length) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
            }
            if (!hilo.isInterrupted()) {
                System.out.println("TOC TOC !");
                hilo.interrupt();
                num_toc_toc++;
            }
        }
    }
}
