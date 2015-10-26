
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioTocToc;

/**
 *
 * @author xvazqdios
 */
public class TocToc {

    public static void main(String[] args) {
       HiloTocToc hilo = new HiloTocToc("Hilo");
       hilo.start();
      for(int i=0;i<=300;i++) {
        try { 
            Thread.sleep(300); 
        } catch (InterruptedException ex) {  }
        hilo.interrupt();
      }
      System.out.println("Fin main");

    }
}
