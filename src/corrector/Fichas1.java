package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fichas1 {

    private JPanel panPrincipal;
    private JButton btnCancelar;
    private JButton btnSiguiente;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JCheckBox fichaDeConsultaCheckBox;

    public Fichas1() {
        btnCancelar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas1
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
    }

    public void abrirFichas1() {
        String tituloForm = "Asistente para la corrección de fichas: Paso 1 de 3 (FICHA)";
        JFrame frame = new JFrame(tituloForm);
        frame.setContentPane(new Fichas1().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(780,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
