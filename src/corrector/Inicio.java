package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Inicio {

    private  JPanel panPrincipal;
    private JTextField tflNombre;
    private JTextField tflContrasena;
    private JButton btnAceptar;
    private JLabel lblDia;
    private JLabel lblHora;
    private JLabel lblContrasena;
    private JLabel lblVersion;


    public Inicio() {

        ponerFechaYHora();


        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
                frame.dispose();            // Cierra Inicio
                Correc crr = new Correc();
                crr.abrirCorrec();           // Abre Correc
            }
        });
    }

    private void ponerFechaYHora(){

        String fecha, hora;
        MetodosLib mLib = new MetodosLib();

        fecha = "Estamos a " + mLib.fechaActual();
        lblDia.setText(fecha);
        hora = "Son las " + mLib.horaActual();
        lblHora.setText(hora);

        lblVersion.setText("Versión " + mLib.versionCrr());
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Corrector");
        frame.setContentPane(new Inicio().panPrincipal);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(570,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
