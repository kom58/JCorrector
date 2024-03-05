package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Correc {

    private JPanel panPrincipal;
    private JButton btnAbrirFicha;
    private JButton btnSalir;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton btnContestar;
    private JButton btnAyudaFch;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton btnOpciones;
    private JButton btnInternet;
    private JLabel lblUsuarioAct;
    private JLabel lblFecha;
    private JLabel lblHora;
    private JLabel lblTiempo;

    public Correc() {

        Datos dt = new Datos();
        lblUsuarioAct.setText(dt.getUsuarioActual());
        ponerFechaYHora();
        abrirFichaArranque();

        if (dt.getEsAdmin()) {
            btnOpciones.setVisible(true);
            btnInternet.setVisible(true);
            btnContestar.setVisible(true);
            btnAyudaFch.setVisible(true);
            } else {
            btnOpciones.setVisible(false);
            btnInternet.setVisible(false);
            btnContestar.setVisible(false);
            btnAyudaFch.setVisible(false);
        }

        btnSalir.addActionListener(e -> System.exit(0));

        btnOpciones.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Correc
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Configuración
        });
        btnAbrirFicha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MetodosLib m = new MetodosLib();
                Datos dt = new Datos();

                dt.setFichaActiva("/Gotico1/index.html");               // !!!!!!!!! Temporal

                if  (!dt.getFichaActiva().isEmpty()) {
                    String abrir = dt.getCarpetaFichas();
                    abrir = abrir + dt.getFichaActiva();
                    m.abrirHTML(abrir);
                }
            }
        });
    }

    public void ponerFechaYHora(){

        String fecha, hora;
        MetodosLib mLib = new MetodosLib();

        fecha = mLib.fechaActual();
        lblFecha.setText(fecha);
        hora = mLib.horaActual();
        lblHora.setText(hora);
    }

    public void abrirFichaArranque(){

        MetodosLib m = new MetodosLib();
        Datos dt = new Datos();

        if  (!dt.getFichaArranque().isEmpty()) {
            String abrir = dt.getCarpetaFichas();
            abrir = abrir + dt.getFichaArranque();
            m.abrirHTML(abrir);
        }
    }

    public void abrirCorrec() {
        JFrame frame = new JFrame("Corrector");
        frame.setContentPane(new Correc().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(630, 180);
        //frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
