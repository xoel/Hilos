/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorVotantes;

/**
 *
 * @author xvazqdios
 */
public class ColegioElectoral {

    public static void main(String[] args) {
        int totalVotos=0,totalIteraciones=0;
        int[] votos = new int[5];
        
        
        final int numVotantes = 10000;
        for (int i = 0; i < numVotantes; i++) {
            System.out.println("Creamos votante "+i);
            Votantes votante = new Votantes("votante");
            votante.start();
            synchronized (votante) {
                //código sincronizado
                System.out.println(votante.votar());
                votos[votante.votar()-1]=votos[votante.votar()-1]+1;
                totalIteraciones++;
                
            }
        }

        System.out.println("Entradas a syncronized: "+totalIteraciones);
        for (int i = 0; i < votos.length; i++) {
            System.out.println("Partido "+(i+1)+": "+votos[i]);
            totalVotos=totalVotos+votos[i];
        }
        System.out.println("Total votos emitidos: "+(votos[0]+votos[1]+votos[2]+votos[3]+votos[4]));
           

    }
}
