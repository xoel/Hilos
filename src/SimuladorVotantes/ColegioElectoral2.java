/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorVotantes;

/**
 *
 * @author xvazqdios
 */
public class ColegioElectoral2 {

    private static int totalVotos = 0;
    private static final int numVotantes = 10000;
    private static final int maxPartidos = 5;    
    static Partido[] urna = new Partido[maxPartidos];
    private static Votantes2[] votantes = new Votantes2[numVotantes];

    public static void main(String[] args) {
        for (int i = 0; i < maxPartidos; i++) {
            Partido partido = new Partido(String.valueOf(i));
            urna[i]=partido;
        }


        for (int i = 0; i < numVotantes; i++) {
            System.out.println("Creamos votante " + i);
            Votantes2 votante = new Votantes2("votante",maxPartidos);
            votantes[i]=votante;
            votante.start();
        }
        
        for (int i = 0; i < votantes.length; i++) {
            try {
                votantes[
                        i].join();
            } catch (InterruptedException ex) {     
                System.out.println("Interrumpido votante: "+i);
            }
        }

        for (int i = 0; i < urna.length; i++) {
            System.out.println("Partido " + (i + 1) + ": " + urna[i].getVotos());
            totalVotos = totalVotos + urna[i].getVotos();
        }

        System.out.println("Total votos emitidos: " + totalVotos);
    }

    
}
