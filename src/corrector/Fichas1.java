package corrector;

import javax.swing.*;

public class Fichas1 {

    private JPanel panPrincipal;
    private JButton btnCancelar;
    private JButton btnSiguiente;
    private JTextField tflNombre;
    private JTextField tflArchInicial;
    private JTextField tflArchAyuda;
    private JComboBox cbxNumPreg;
    private JComboBox cbxArea;
    private JComboBox cbxNivel;
    private JComboBox cbxCurso;
    private JTextField tflTema;
    private JButton btnArchInicial;
    private JButton btnArchAyuda;
    private JCheckBox cbxEsFchConsulta;

    public Fichas1() {
        btnCancelar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas1
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
        btnSiguiente.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas1
            Fichas2 f2 = new Fichas2();
            f2.abrirFichas2();           // Abre Opciones
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
