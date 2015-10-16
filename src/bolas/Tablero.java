
package bolas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    private static Tablero tablero = new Tablero();
    private static ArrayList<Bola> listaBolas;

    private Tablero() {
        listaBolas = new ArrayList();
        this.setPreferredSize(new Dimension(700, 400));
        this.setBackground(Color.WHITE);
    }
    
    public static Tablero getInstance() {
        return tablero;
    }

    public static void nuevaBola(Bola bola) {
        listaBolas.add(bola);
        bola.start();
    }
    
    public static void finDelJuego() {
        for(Bola bola : listaBolas)
            bola.interrupt();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibujamos el nº de bolas actual (debug)
        g.drawString(listaBolas.size() + "", 160, 10);
        
        for (int i = listaBolas.size() - 1; i >= 0; i--) {
            Bola bola = listaBolas.get(i);
            
            if(!bola.isAlive())
                listaBolas.remove(bola);
            else if (!bola.vive())
                bola.fin();
            else
                bola.pinta(g);
        }

    }
}