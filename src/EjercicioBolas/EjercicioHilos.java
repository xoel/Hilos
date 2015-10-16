/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioBolas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author xvazqdios
 */
public class EjercicioHilos implements ActionListener {

    private static final String cArchivo = "Archivo";
    private static final String cDisparoLento = "Disparo Lento";
    private static final String cDisparoNormal = "Disparo Normal";
    private static final String cDisparoRapido = "Disparo Rápido";
    private static final String cSalir = "Salir";
    Tablero tablero = new Tablero();
    JFrame frame = new JFrame("Disparos");
    JMenu mArchivo;
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton bDisparoLento = new JButton(cDisparoLento);
    JButton bDisparoNormal = new JButton(cDisparoNormal);
    JButton bDisparoRapido = new JButton(cDisparoRapido);

    public static void main(String[] args) {
        new EjercicioHilos().run();
    }

    private void añadeMenu(JFrame frame) {
        mArchivo = new JMenu(cArchivo);
        JMenuItem iDisparoLento = new JMenuItem(cDisparoLento);
        JMenuItem iDisparoNormal = new JMenuItem(cDisparoNormal);
        JMenuItem iDisparoRapido = new JMenuItem(cDisparoRapido);

        iDisparoLento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        iDisparoNormal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        iDisparoRapido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        iDisparoLento.addActionListener(this);
        iDisparoNormal.addActionListener(this);
        iDisparoRapido.addActionListener(this);

        JMenuItem iSalir = new JMenuItem(cSalir);
        iSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        iSalir.addActionListener(this);

        mArchivo.add(iDisparoLento);
        mArchivo.add(iDisparoNormal);
        mArchivo.add(iDisparoRapido);
        mArchivo.addSeparator();
        mArchivo.add(iSalir);
        JMenuBar menu = new JMenuBar();
        menu.add(mArchivo);
        frame.setJMenuBar(menu);
    }

    public void run() {
        añadeMenu(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        bDisparoLento.addActionListener(this);
        bDisparoNormal.addActionListener(this);
        bDisparoRapido.addActionListener(this);
        buttonPanel.add(bDisparoLento);
        buttonPanel.add(bDisparoNormal);
        buttonPanel.add(bDisparoRapido);
        frame.getContentPane().add(tablero, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(cSalir)) {
            // Fin del juego
            System.exit(0);
        }
        if(command.equals(bDisparoLento)){
            Bola bola = new Bola(0,0,100,100,2,Color.RED);
            tablero.añadirBola(bola);
            tablero.paint(tablero.getGraphics());
            bola.start();
        }


    }
}
