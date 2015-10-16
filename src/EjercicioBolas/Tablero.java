/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioBolas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author xvazqdios
 */
public class Tablero extends JPanel {

    private ArrayList<Bola> listaBolas = new ArrayList();   
    
    public Tablero() {
        setPreferredSize(new Dimension(700, 300));
        setBackground(Color.WHITE);
    }

    public void añadirBola(Bola bola){
        listaBolas.add(bola);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Bola bola : listaBolas) {
            bola.pintarBola(g);
            repaint();
        }
    }
}
