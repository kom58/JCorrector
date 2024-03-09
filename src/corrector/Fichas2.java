package corrector;

import javax.swing.*;

public class Fichas2 {

    private JPanel panPrincipal;
    private JTextArea tarRespuesta;
    private JButton btnCancelar;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnPregSiguiente;
    private JButton btnPregAnterior;
    private JTextField tflComandos;
    private JRadioButton rbtVF;
    private JRadioButton rbtABC;
    private JRadioButton rbtSN;
    private JRadioButton rbt123;
    private JRadioButton rbtTxtLibre;
    private JRadioButton rbtDifResp;
    private JRadioButton rbtRespExacta;

    public Fichas2() {

        Datos d = new Datos();          // Falta bucle de Numero de preguntas
        tflComandos.setText(d.getComandosFch());
        // Aquí todos los tipos de Fch
        tarRespuesta.append(d.getRespuestaPreguntaFch());


        btnCancelar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas2
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
        btnAnterior.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas2
            Fichas1 f1 = new Fichas1();
            f1.abrirFichas1();              // Abre Opciones
        });
        btnSiguiente.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas2
            Fichas3 f3 = new Fichas3();
            f3.abrirFichas3();              // Abre Fichas3
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
