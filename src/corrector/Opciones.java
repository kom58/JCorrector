package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Opciones {

    private JPanel panPrincipal;
    private JButton configuraciónButton;
    private JButton cerrarButton;
    private JButton abrirInformeButton;
    private JButton modificarFichaActualButton;
    private JButton nuevaFichaButton;


    public Opciones() {
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Opciones");
        frame.setContentPane(new Opciones().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
