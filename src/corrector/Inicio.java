package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Inicio {

    private  JPanel panPrincipal;
    private JLabel lblTitulo;
    private JTextField tflNombre;
    private JTextField tflContrasena;
    private JButton btnAceptar;
    private JLabel lblVanG;
    private JLabel lblDia;
    private JLabel lblHora;
    private JLabel lblContrasena;
    private int diaA, mesA, anoA;
    private int horaA, minA;


    public Inicio() {

        ponerFechaActual();

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblContrasena.setVisible(true);
                tflContrasena.setVisible(true);
            }
        });
    }

    private void ponerFechaActual(){

        String fechaActual, horaActual;
        Calendar ahora = Calendar.getInstance();
        diaA = ahora.get(Calendar.DAY_OF_MONTH);
        mesA = ahora.get(Calendar.MONTH) + 1;
        anoA = ahora.get(Calendar.YEAR);
        horaA = ahora.get(Calendar.HOUR_OF_DAY);
        minA = ahora.get(Calendar.MINUTE);

        fechaActual = "Estamos a " + diaA + "." + mesA + "." + anoA;
        lblDia.setText(fechaActual);
        horaActual = "Son las " + horaA + ":" + minA;
        lblHora.setText(horaActual);

    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Inicio");
        frame.setContentPane(new Inicio().panPrincipal);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(520,450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
