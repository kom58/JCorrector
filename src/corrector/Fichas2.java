package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fichas2 {

    private JPanel panPrincipal;
    private JTextArea textArea1;
    private JButton btnCancelar;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JRadioButton verdaderoFalsoRadioButton;
    private JRadioButton aBCLRadioButton;
    private JRadioButton síNoRadioButton;
    private JRadioButton a12325RadioButton;
    private JRadioButton textoLibreRadioButton;
    private JRadioButton diferentesRespuestasPosiblesConsultarRadioButton;
    private JRadioButton respuestaExactaAUnaRadioButton;

    public Fichas2() {
        btnCancelar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas1
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
        btnAnterior.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas1
            Fichas1 f1 = new Fichas1();
            f1.abrirFichas1();           // Abre Opciones
        });
    }

    public  void abrirFichas2() {
        String tituloForm = "Asistente para la corrección de fichas: Paso 2 de 3 (RESPUESTAS)";
        JFrame frame = new JFrame(tituloForm);
        frame.setContentPane(new Fichas2().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(570,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
