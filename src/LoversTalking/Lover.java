/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoversTalking;


/**
 *
 * @author xvazqdios
 */
public class Lover extends Thread{
    WriteAndTalk writeAndTalk;
    public Lover(String nombre, WriteAndTalk writeAndTalk) {
        super(nombre);
        this.writeAndTalk=writeAndTalk;
        
    }
    
    

    @Override
    public void run() {
        writeAndTalk.talk();
    }
    
    
    
}
