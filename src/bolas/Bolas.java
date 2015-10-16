/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas;

/**
 *
 * @author david
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Bolas implements ActionListener {

    private static final String cArchivo = "Archivo";
    private static final String cDisparoLento = "Disparo Lento";
    private static final String cDisparoNormal = "Disparo Normal";
    private static final String cDisparoRapido = "Disparo RÃ¡pido";
    private static final String cBolaDisparo = "Tipo disparo";
    private static final String cBolaRebota = "Tipo rebota";
    private static final String cSalir = "Salir";

    Tablero tablero = Tablero.getInstance();

    JFrame frame = new JFrame("Disparos");
    JMenu mArchivo;
    JCheckBoxMenuItem iTipoBolaDisparo, iTipoBolaRebota;
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton bDisparoLento = new JButton(cDisparoLento);
    JButton bDisparoNormal = new JButton(cDisparoNormal);
    JButton bDisparoRapido = new JButton(cDisparoRapido);

    public static void main(String[] args) {
        new Bolas().run();
    }

    private void añadeMenu(JFrame frame) {
        mArchivo = new JMenu(cArchivo);
        JMenuItem iDisparoLento = new JMenuItem(cDisparoLento);
        JMenuItem iDisparoNormal = new JMenuItem(cDisparoNormal);
        JMenuItem iDisparoRapido = new JMenuItem(cDisparoRapido);
        iTipoBolaDisparo = new JCheckBoxMenuItem(cBolaDisparo, false);
        iTipoBolaRebota = new JCheckBoxMenuItem(cBolaRebota, true);

       iDisparoLento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
       iDisparoNormal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
       iDisparoRapido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
       iDisparoLento.addActionListener(this);
       iDisparoNormal.addActionListener(this);
       iDisparoRapido.addActionListener(this);
       iTipoBolaDisparo.addActionListener(this);
       iTipoBolaRebota.addActionListener(this);

        JMenuItem iSalir = new JMenuItem(cSalir);
        iSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        iSalir.addActionListener(this);

        mArchivo.add(iDisparoLento);
        mArchivo.add(iDisparoNormal);
        mArchivo.add(iDisparoRapido);
        mArchivo.addSeparator();
        mArchivo.add(iTipoBolaDisparo);
        mArchivo.add(iTipoBolaRebota);
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
        tablero.setPreferredSize(new Dimension(700, 300));
        tablero.setBackground(Color.WHITE);
        frame.getContentPane().add(tablero, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public void setTipoDisparo(String command) {
        iTipoBolaDisparo.setSelected(command.equals(cBolaDisparo));
        iTipoBolaRebota.setSelected(command.equals(cBolaRebota));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(cSalir)) {
            tablero.finDelJuego();
            System.exit(0);
        }

        if (command.equals(cBolaDisparo) || command.equals(cBolaRebota)) {
            setTipoDisparo(command);
            return;
        }

        Bola.Velocidad velocidad = Bola.Velocidad.NORMAL;
        if (command.equals(cDisparoLento))
            velocidad = Bola.Velocidad.LENTO;
        else if (command.equals(cDisparoRapido))
            velocidad = Bola.Velocidad.RAPIDO;

        Bola bola = null;
        if (iTipoBolaDisparo.isSelected())
            bola = new BolaDisparo(velocidad);
        else if (iTipoBolaRebota.isSelected())
            bola = new BolaRebota(velocidad);

        if (bola != null)
            tablero.nuevaBola(bola);
        else
            JOptionPane.showMessageDialog(frame, "Tipo de bola desconocido");
    }
}