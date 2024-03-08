package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fichas3 {

    private JPanel panPrincipal;
    private JButton btnCancelar;
    private JButton btnAnterior;
    private JButton btnGuardar;
    private JTextField textField1;
    private JCheckBox calculadoraCheckBox;
    private JCheckBox blocDeNotasCheckBox;
    private JCheckBox ayudaDelCorrectorCheckBox;
    private JCheckBox cronómetroCheckBox;
    private JRadioButton mostrarErroresPendientesRadioButton;
    private JRadioButton todosLosEjerciciosCorrectosRadioButton;
    private JRadioButton informeConPreguntasMalRadioButton;
    private JRadioButton controlDeEvaluaciónRadioButton;
    private JTextField textField2;
    private JTextField textField3;

    public Fichas3() {
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
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas3
            Correc crr = new Correc();
            crr.abrirCorrec();              // Abre Correc
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosLib m = new MetodosLib();
                m.escribirFichaCrr();
            }
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
}
