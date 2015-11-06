/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorVotantes;

/**
 *
 * @author xvazqdios
 */
public class Partido {
    private int votos;
    private String Partido;

    public Partido( String Partido) {
        this.votos = votos=0;
        this.Partido = Partido;
    }
    
    public void votar(){
        synchronized(this){
            votos++;
        }
    }

    public int getVotos() {
        return votos;
    }

    public String getPartido() {
        return Partido;
    }
    
    
}
