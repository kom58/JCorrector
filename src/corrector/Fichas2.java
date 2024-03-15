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
    private JComboBox cbxRespuesta;
    private JLabel lblNumPreg;
    private JPanel panTxtRespuesta;
    private JPanel panCbxRespuesta;
    private int numPregActual = 1;
    private String[] comandosPreg;
    private String[] tipoPreg;
    private String[] respuestaPreg;

    public Fichas2() {

        Datos d = new Datos();          // Inicializando arrays

        comandosPreg = new String[Integer.parseInt(d.getNumeroPreguntasFch())];
        tipoPreg = new String[Integer.parseInt(d.getNumeroPreguntasFch())];
        respuestaPreg = new String[Integer.parseInt(d.getNumeroPreguntasFch())];

        ButtonGroup grupo1 = new ButtonGroup();             // Grupo 1
        ButtonGroup grupo2 = new ButtonGroup();             // Grupo 2
        grupo1.add(rbtVF);
        grupo1.add(rbtSN);
        grupo1.add(rbtABC);
        grupo1.add(rbt123);
        grupo1.add(rbtTxtLibre);
        grupo2.add(rbtDifResp);
        grupo2.add(rbtRespExacta);

        lblNumPreg.setText(numPregActual + " / " + d.getNumeroPreguntasFch());      // Pone NumPreg
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
            f1.abrirFichas1();              // Abre Fichas1
        });
        btnSiguiente.addActionListener(e -> {
            guardarDatosFichas2();          // Guarda datos Ficha 2
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas2
            Fichas3 f3 = new Fichas3();
            f3.abrirFichas3();              // Abre Fichas3
        });
        btnPregAnterior.addActionListener(e -> {
            if (numPregActual > 1) {
                numPregActual--;
                lblNumPreg.setText(numPregActual + " / " + d.getNumeroPreguntasFch());      // Pone NumPreg
            }
        });
        btnPregSiguiente.addActionListener(e -> {
            if (numPregActual < Integer.parseInt(d.getNumeroPreguntasFch())) {
                numPregActual++;
                lblNumPreg.setText(numPregActual + " / " + d.getNumeroPreguntasFch());      // Pone NumPreg
            }

        });
        rbtTxtLibre.addActionListener(e -> radioBotonSeleccionado());
        rbtSN.addActionListener(e -> radioBotonSeleccionado());
        rbtVF.addActionListener(e -> radioBotonSeleccionado());
        rbtABC.addActionListener(e -> radioBotonSeleccionado());
        rbt123.addActionListener(e -> radioBotonSeleccionado());
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

    public void guardarDatosFichas2() {

        Datos d = new Datos();
        d.setComandosFch(tflComandos.getText());
        // Aqí todos los tipos de Fch
        d.setRespuestaPreguntaFch(tarRespuesta.getText());

    }

    public void radioBotonSeleccionado() {

        if (rbtTxtLibre.isSelected()) {
            rbtDifResp.setEnabled(true);
            rbtRespExacta.setEnabled(true);
            panTxtRespuesta.setVisible(true);
            panCbxRespuesta.setVisible(false);
        } else {
            rbtDifResp.setEnabled(false);
            rbtRespExacta.setEnabled(false);
            panTxtRespuesta.setVisible(false);
            panCbxRespuesta.setVisible(true);
        }

    }

}
