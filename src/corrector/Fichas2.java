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
    private JTextField tflComandosPrg;
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
    private JRadioButton rbtIA;
    private int numPregActual = 1;

    public Fichas2() {

        Datos d = new Datos();

        int x =  Integer.parseInt(d.getNumeroPreguntasFch());      // NumeroPreguntasFch

        if (d.getEsNuevaFch()) {                                    // Si es nueva se inicializan arrays
            d.inicializarComTipResp(x);
        }

        ponerRadioSeleccionado();


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
        // tflComandosPrg.setText(d.getComandosFch());
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

                guardarRespuestaActual();
                verRadioSeleccionado();

                numPregActual--;

                ponerRadioSeleccionado();
                lblNumPreg.setText(numPregActual + " / " + d.getNumeroPreguntasFch());      // Pone NumPreg
            }
        });
        btnPregSiguiente.addActionListener(e -> {
            if (numPregActual < Integer.parseInt(d.getNumeroPreguntasFch())) {

                guardarRespuestaActual();
                verRadioSeleccionado();

                numPregActual++;

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

        verRadioSeleccionado();
        guardarRespuestaActual();

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

        Datos d = new Datos();
        String seleccionado = "";

        if (rbtVF.isSelected()) {
            seleccionado = "VF";
            d.setRespPregunta(numPregActual, (String) cbxRespuesta.getSelectedItem());
            d.setTipoPreg(numPregActual, seleccionado);
            d.setComandosPreg(numPregActual, tflComandosPrg.getText());
        } else if (rbtSN.isSelected()) {
            seleccionado = "SN";
            d.setRespPregunta(numPregActual, (String) cbxRespuesta.getSelectedItem());
            d.setTipoPreg(numPregActual, seleccionado);
            d.setComandosPreg(numPregActual, tflComandosPrg.getText());
        } else if (rbt123.isSelected()) {
            seleccionado = "123";
            d.setRespPregunta(numPregActual, (String) cbxRespuesta.getSelectedItem());
            d.setTipoPreg(numPregActual, seleccionado);
            d.setComandosPreg(numPregActual, tflComandosPrg.getText());
        } else if (rbtABC.isSelected()) {
            seleccionado = "ABC";
            d.setRespPregunta(numPregActual, (String) cbxRespuesta.getSelectedItem());
            d.setTipoPreg(numPregActual, seleccionado);
            d.setComandosPreg(numPregActual, tflComandosPrg.getText());
        } else if (rbtRespExacta.isSelected()) {
            seleccionado = "Exacta";
            String texto = tarRespuesta.getText();
            texto = texto.replaceAll("\\R", "/&/");        // Sustituye saltos de línea por /&/
            d.setRespPregunta(numPregActual, texto);
            d.setTipoPreg(numPregActual, seleccionado);
            d.setComandosPreg(numPregActual, tflComandosPrg.getText());
        } else if (rbtDifResp.isSelected()) {
            seleccionado = "Diferente";
            String texto = tarRespuesta.getText();
            texto = texto.replaceAll("\\R", "/&/");        // Sustituye saltos de línea por /&/
            d.setRespPregunta(numPregActual, texto);
            d.setTipoPreg(numPregActual, seleccionado);
            d.setComandosPreg(numPregActual, tflComandosPrg.getText());
        } else if (rbtIA.isSelected()) {
            seleccionado = "IA";
            String texto = tarRespuesta.getText();
            texto = texto.replaceAll("\\R", "/&/");        // Sustituye saltos de línea por /&$/
            d.setRespPregunta(numPregActual, texto);
            d.setTipoPreg(numPregActual, seleccionado);
            d.setComandosPreg(numPregActual, tflComandosPrg.getText());
        }

        return seleccionado;
    }

    public void ponerRadioSeleccionado() {

        Datos d = new Datos();
        String tipo = d.getTipoPreg(numPregActual);
        

        if (tipo != null && !tipo.isEmpty())  {
            if (tipo.equals("VF")) {
                rbtVF.setSelected(true); // Selecciona el botón de radio "VF"
                rbtRespExacta.setEnabled(false);
                rbtDifResp.setEnabled(false);
                radioBotonSeleccionado();
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(d.getRespPregunta(numPregActual)); // Establece la respuesta en el JComboBox
                tflComandosPrg.setText(d.getComandosPreg(numPregActual));       // Establece Comandos Pregunta
            } else if (tipo.equals("SN")) {
                rbtSN.setSelected(true); // Selecciona el botón de radio "SN"
                rbtRespExacta.setEnabled(false);
                rbtDifResp.setEnabled(false);
                radioBotonSeleccionado();
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(d.getRespPregunta(numPregActual)); // Establece la respuesta en el JComboBox
                tflComandosPrg.setText(d.getComandosPreg(numPregActual));       // Establece Comandos Pregunta
            } else if (tipo.equals("123")) {
                rbt123.setSelected(true); // Selecciona el botón de radio "123"
                rbtRespExacta.setEnabled(false);
                rbtDifResp.setEnabled(false);
                radioBotonSeleccionado();
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(d.getRespPregunta(numPregActual)); // Establece la respuesta en el JComboBox
                tflComandosPrg.setText(d.getComandosPreg(numPregActual));       // Establece Comandos Pregunta
            } else if (tipo.equals("ABC")) {
                rbtABC.setSelected(true); // Selecciona el botón de radio "ABC"
                rbtRespExacta.setEnabled(false);
                rbtDifResp.setEnabled(false);
                radioBotonSeleccionado();
                panTxtRespuesta.setVisible(false);
                panCbxRespuesta.setVisible(true);
                cbxRespuesta.setSelectedItem(d.getRespPregunta(numPregActual)); // Establece la respuesta en el JComboBox
                tflComandosPrg.setText(d.getComandosPreg(numPregActual));       // Establece Comandos Pregunta
            } else if (tipo.equals("Exacta")) {
                rbtRespExacta.setSelected(true); // Selecciona el botón de radio "Exacta"
                rbtTxtLibre.setSelected(true);
                rbtRespExacta.setEnabled(true);
                rbtDifResp.setEnabled(true);
                radioBotonSeleccionado();
                panTxtRespuesta.setVisible(true);
                panCbxRespuesta.setVisible(false);
                String texto = d.getRespPregunta(numPregActual);
                texto = texto.replace("/&/", System.lineSeparator());    // Coloca saltos de línea
                tarRespuesta.setText(texto);                                    // Establece la respuesta en el JTextArea
                tflComandosPrg.setText(d.getComandosPreg(numPregActual));       // Establece Comandos Pregunta
            } else if (tipo.equals("Diferente")) {
                rbtDifResp.setSelected(true); // Selecciona el botón de radio "Diferente"
                rbtTxtLibre.setSelected(true);
                rbtRespExacta.setEnabled(true);
                rbtDifResp.setEnabled(true);
                radioBotonSeleccionado();
                panTxtRespuesta.setVisible(true);
                panCbxRespuesta.setVisible(false);
                String texto = d.getRespPregunta(numPregActual);
                texto = texto.replace("/&/", System.lineSeparator());    // Coloca saltos de línea
                tarRespuesta.setText(texto);                                    // Establece la respuesta en el JTextArea
                tflComandosPrg.setText(d.getComandosPreg(numPregActual));       // Establece Comandos Pregunta
            }

        }
    }

    private void guardarRespuestaActual() {

        Datos d = new Datos();

        String respuesta;

        if (rbtTxtLibre.isSelected()) {
            // La respuesta está en el JTextArea
            respuesta = tarRespuesta.getText();
            respuesta = respuesta.replaceAll("\\R", "/&/");
        } else {
            // La respuesta está en el JComboBox
            respuesta = (String) cbxRespuesta.getSelectedItem();
        }

        if (respuesta == null) {
            respuesta = "";
        }

        d.respPregunta.set(numPregActual, respuesta);

    }
}
