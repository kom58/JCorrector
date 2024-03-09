package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fichas3 {

    private JPanel panPrincipal;
    private JButton btnCancelar;
    private JButton btnAnterior;
    private JButton btnGuardar;
    private JTextField tflComandosIni;
    private JCheckBox cbxCalculadora;
    private JCheckBox cbxBloc;
    private JCheckBox cbxAyudaCrr;
    private JCheckBox cbxCrono;
    private JRadioButton rbtEjerCorrec;
    private JRadioButton rbtMostrarErrores;
    private JRadioButton rbtInformePrMal;
    private JRadioButton rbtControl;
    private JTextField tflEmail;
    private JTextField tflInforme;

    public Fichas3() {

        Datos d = new Datos();
        tflComandosIni.setText(d.getComandosInicioFch());
        cbxCalculadora.setSelected(d.getActivarCalcFch());
        cbxBloc.setSelected(d.getActivarBlocFch());
        cbxAyudaCrr.setSelected(d.getActivarAyudaCrrFch());
        cbxCrono.setSelected(d.getActivarCronoFch());
        // Aquí tipo de corrección
        tflEmail.setText(d.getEnvioEmailFch());
        tflInforme.setText(d.getEnvioInformeFch());

        btnAnterior.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas3
            Fichas2 f2 = new Fichas2();
            f2.abrirFichas2();              // Abre Ficha2
        });
        btnCancelar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                    // Cierra Fichas3
            Opciones opc = new Opciones();
            opc.abrirOpciones();                // Abre Opciones
        });
        btnGuardar.addActionListener(e -> {
            guardarDatosFichas3();              // Guarda Datos Fichas3
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            MetodosLib m = new MetodosLib();
            m.escribirFichaCrr();               // Guarda Fch en Crr
            frame.dispose();                    // Cierra Fichas3
            Correc crr = new Correc();
            crr.abrirCorrec();                  // Abre Correc
        });
    }

    public  void abrirFichas3() {
        String tituloForm = "Asistente para la corrección de fichas: Paso 3 de 3 (PROGRAMA)";
        JFrame frame = new JFrame(tituloForm);
        frame.setContentPane(new Fichas3().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(570,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void guardarDatosFichas3() {

        Datos d = new Datos();
        d.setComandosInicioFch(tflComandosIni.getText());
        d.setActivarCalcFch(cbxCalculadora.isSelected());
        d.setActivarBlocFch(cbxBloc.isSelected());
        d.setActivarAyudaCrrFch(cbxAyudaCrr.isSelected());
        d.setActivarCronoFch(cbxCrono.isSelected());
        // Aquí tipo de corrección
        d.setEnvioEmailFch(tflEmail.getText());
        d.setEnvioInformeFch(tflInforme.getText());
    }
}
