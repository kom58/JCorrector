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

        Datos d = new Datos();

        int x =  Integer.parseInt(d.getNumeroPreguntasFch());       // NumeroPreguntasFch

        comandosPreg = new String[x];
        tipoPreg = new String[x];
        respuestaPreg = new String[x];

        for (int i = 0 ; i  <= x-1 ; i++){                          // Se inicializan arrays
            comandosPreg[i] = "";
            tipoPreg[i] = "";
            respuestaPreg[i] = "";
        }


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
        // tflComandos.setText(d.getComandosFch());
        // Aquí todos los tipos de Fch
        // tarRespuesta.append(d.getRespuestaPreguntaFch());

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
                comandosPreg[numPregActual-1] = tflComandos.getText();      // Guarda ComandosPreg
                tipoPreg[numPregActual-1] = verRadioSeleccionado();         // Guarda Tipo y Respuesta Preg

                numPregActual--;
                tflComandos.setText(comandosPreg[numPregActual - 1]);
                ponerRadioSeleccionado();
                lblNumPreg.setText(numPregActual + " / " + d.getNumeroPreguntasFch());      // Pone NumPreg
            }
        });
        btnPregSiguiente.addActionListener(e -> {
            if (numPregActual < Integer.parseInt(d.getNumeroPreguntasFch())) {
                comandosPreg[numPregActual-1] = tflComandos.getText();      // Guarda ComandosPreg
                tipoPreg[numPregActual-1] = verRadioSeleccionado();         // Guarda Tipo y Respuesta Preg

                numPregActual++;
                tflComandos.setText(comandosPreg[numPregActual - 1]);
                ponerRadioSeleccionado();
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

        if (rbtTxtLibre.isSelected()) {                 // Texto libre
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

        if (rbtVF.isSelected()) {                       // Verdadero falso
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Verdadero");
            model.addElement("Falso");
            cbxRespuesta.setModel(model);
        }

        if (rbtSN.isSelected()) {                       // Si No
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Sí");
            model.addElement("No");
            cbxRespuesta.setModel(model);
        }

        if (rbtABC.isSelected()) {                      // A B C
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("A");
            model.addElement("B");
            model.addElement("C");
            model.addElement("D");
            model.addElement("E");
            model.addElement("F");
            model.addElement("G");
            model.addElement("H");
            model.addElement("I");
            model.addElement("J");
            model.addElement("K");
            model.addElement("L");
            cbxRespuesta.setModel(model);
        }

        if (rbt123.isSelected()) {                      // 123
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("1");
            model.addElement("2");
            model.addElement("3");
            model.addElement("4");
            model.addElement("5");
            model.addElement("6");
            model.addElement("7");
            model.addElement("8");
            model.addElement("9");
            model.addElement("10");
            model.addElement("11");
            model.addElement("12");
            model.addElement("13");
            model.addElement("14");
            model.addElement("15");
            model.addElement("16");
            model.addElement("17");
            model.addElement("18");
            model.addElement("19");
            model.addElement("20");
            model.addElement("21");
            model.addElement("22");
            model.addElement("23");
            model.addElement("24");
            model.addElement("25");
            cbxRespuesta.setModel(model);
        }
    }

    public String verRadioSeleccionado() {

        String seleccionado = "";

        if (rbtVF.isSelected()) {
            seleccionado = "VF";
            respuestaPreg[numPregActual - 1] = (String) cbxRespuesta.getSelectedItem();
        } else if (rbtSN.isSelected()) {
            seleccionado = "SN";
            respuestaPreg[numPregActual - 1] = (String) cbxRespuesta.getSelectedItem();
        } else if (rbt123.isSelected()) {
            seleccionado = "123";
            respuestaPreg[numPregActual - 1] = (String) cbxRespuesta.getSelectedItem();
        } else if (rbtABC.isSelected()) {
            seleccionado = "ABC";
            respuestaPreg[numPregActual - 1] = (String) cbxRespuesta.getSelectedItem();
        } else if (rbtRespExacta.isSelected()) {
            seleccionado = "Exacta";
            respuestaPreg[numPregActual - 1] = tarRespuesta.getText();
        } else if (rbtDifResp.isSelected()) {
            seleccionado = "Diferente";
            respuestaPreg[numPregActual - 1] = tarRespuesta.getText();
        }

        return seleccionado;
    }

    public void ponerRadioSeleccionado() {

        String tipo = tipoPreg[numPregActual - 1];

        if (tipo != "") {
            if (tipo.equals("VF")) {
                rbtVF.setSelected(true); // Selecciona el botón de radio "VF"
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(respuestaPreg[numPregActual - 1]); // Establece la respuesta en el JComboBox
            } else if (tipo.equals("SN")) {
                rbtSN.setSelected(true); // Selecciona el botón de radio "SN"
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(respuestaPreg[numPregActual - 1]); // Establece la respuesta en el JComboBox
            } else if (tipo.equals("123")) {
                rbt123.setSelected(true); // Selecciona el botón de radio "123"
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(respuestaPreg[numPregActual - 1]); // Establece la respuesta en el JComboBox
            } else if (tipo.equals("ABC")) {
                rbtABC.setSelected(true); // Selecciona el botón de radio "ABC"
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(respuestaPreg[numPregActual - 1]); // Establece la respuesta en el JComboBox
            } else if (tipo.equals("Exacta")) {
                rbtRespExacta.setSelected(true); // Selecciona el botón de radio "Exacta"
                panTxtRespuesta.setVisible(true);
                panCbxRespuesta.setVisible(false);
                tarRespuesta.setText(respuestaPreg[numPregActual - 1]); // Establece la respuesta en el JTextArea
            } else if (tipo.equals("Diferente")) {
                rbtDifResp.setSelected(true); // Selecciona el botón de radio "Diferente"
                panTxtRespuesta.setVisible(true);
                panCbxRespuesta.setVisible(false);
                tarRespuesta.setText(respuestaPreg[numPregActual - 1]); // Establece la respuesta en el JTextArea
            }
        }

    }
}
