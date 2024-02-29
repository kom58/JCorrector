package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Correc {

    private JPanel panPrincipal;
    private JButton button1;
    private JButton btnSalir;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton btnOpciones;
    private JButton button14;
    private JButton button15;

    public Correc() {
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
                frame.dispose();                // Cierra Correc
                Opciones opc = new Opciones();
                opc.abrirOpciones();           // Abre Configuración
            }
        });
    }

    public  void abrirCorrec() {
        JFrame frame = new JFrame("Corrector");
        frame.setContentPane(new Correc().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(630,180);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
