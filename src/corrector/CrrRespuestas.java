package corrector;

import javax.swing.*;

public class CrrRespuestas {
    private JPanel panPrincipal;
    private JButton btnFinalizar;
    private JButton btnSiguiente;
    private JButton btnAnterior;
    private JTextArea tarRespuesta;
    private JLabel lblTiempo;
    private JLabel lblPreg;
    private JLabel lblNumPreg;
    private JLabel lblRespActual;
    private JPanel cbxPanel;
    private JScrollPane scrollPanel;
    private JComboBox cbxRespuesta;
    private int numPregActual=1;
    private int numPreguntas;

    public CrrRespuestas() {

        Datos d = new Datos();
        numPreguntas =  Integer.parseInt(d.getNumeroPreguntasFch());      // NumeroPreguntasFch

        lblNumPreg.setText(Integer.toString(numPreguntas));
        lblPreg.setText(Integer.toString(numPregActual));
        lblRespActual.setText(Integer.toString(numPregActual));

                                        // Inicializar respuestas del usuario
        if (Datos.respUsuario.size() != numPreguntas + 1) {
            Datos.respUsuario.clear();
            for (int i = 0; i <= numPreguntas; i++) {
                Datos.respUsuario.add("");
            }
        }

        verTipoPreg();                  // Mostrar primera pregunta


        btnFinalizar.addActionListener(e -> {
            guardarRespuestaActual();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                    // Cierra CrrRespuestas
            Correc cr = new Correc();
            cr.abrirCorrec();                   // Abre Correc
        });

        btnAnterior.addActionListener(e -> {
            if (numPregActual > 1 ) {
                guardarRespuestaActual();
                numPregActual--;
                lblPreg.setText(Integer.toString(numPregActual));
                lblRespActual.setText(Integer.toString(numPregActual));
                verTipoPreg();
            }
        });

        btnSiguiente.addActionListener(e -> {
            guardarRespuestaActual();
            if (numPregActual < numPreguntas){
                numPregActual++;
                lblPreg.setText(Integer.toString(numPregActual));
                lblRespActual.setText(Integer.toString(numPregActual));
                verTipoPreg();
            }
        });

    }

    public void verTipoPreg() {
        Datos d = new Datos();
        String tipo = d.getTipoPreg(numPregActual);

        if (tipo == null || tipo.isEmpty()) {return;}

        if (tipo.equals("VF")) {
            mostrarCombo();
            DefaultComboBoxModel<String> model =
                    new DefaultComboBoxModel<>();
            model.addElement("Verdadero");
            model.addElement("Falso");
            cbxRespuesta.setModel(model);
            cargarRespuestaUsuario();
        } else if (tipo.equals("SN")) {
            mostrarCombo();
            DefaultComboBoxModel<String> model =
                    new DefaultComboBoxModel<>();
            model.addElement("Sí");
            model.addElement("No");
            cbxRespuesta.setModel(model);
            cargarRespuestaUsuario();
        } else if (tipo.equals("123")) {
            mostrarCombo();
            DefaultComboBoxModel<String> model =
                    new DefaultComboBoxModel<>();
            for (int i = 1; i <= 25; i++) {
                model.addElement(Integer.toString(i));
            }
            cbxRespuesta.setModel(model);
            cargarRespuestaUsuario();
        } else if (tipo.equals("ABC")) {
            mostrarCombo();
            DefaultComboBoxModel<String> model =
                    new DefaultComboBoxModel<>();
            for (char c = 'A'; c <= 'L'; c++) {
                model.addElement(Character.toString(c));
            }
            cbxRespuesta.setModel(model);
            cargarRespuestaUsuario();
        } else if (tipo.equals("Exacta")) {
            mostrarTexto();
            cargarRespuestaUsuario();
        } else if (tipo.equals("Diferente")) {
            mostrarTexto();
            cargarRespuestaUsuario();
        } else if (tipo.equals("IA")) {
            mostrarTexto();
            cargarRespuestaUsuario();
    }
        }

        private void mostrarCombo() {
            scrollPanel.setVisible(false);
            cbxRespuesta.setVisible(true);
        }

    public void guardarRespuestaActual(){

        String respuesta;
        Datos d = new Datos();
        String tipo = d.getTipoPreg(numPregActual);

        if (tipo.equals("Exacta")
                || tipo.equals("Diferente")
                || tipo.equals("IA")) {
            respuesta = tarRespuesta.getText();
            respuesta = respuesta.replaceAll("\\R", "/&/");     // Igual que en Fichas2
        } else {
            Object seleccionado =
                    cbxRespuesta.getSelectedItem();
            if (seleccionado != null) {
                respuesta = seleccionado.toString();
            } else {
                respuesta = "";
            }
        }

        Datos.respUsuario.set(numPregActual, respuesta);

    }

    private void cargarRespuestaUsuario() {

        String respuesta = Datos.respUsuario.get(numPregActual);

        if (respuesta == null) {
            respuesta = "";
        }

        Datos d = new Datos();
        String tipo = d.getTipoPreg(numPregActual);

        if (tipo.equals("Exacta")
                || tipo.equals("Diferente")
                || tipo.equals("IA")) {
            respuesta = respuesta.replace("/&/", System.lineSeparator());
            tarRespuesta.setText(respuesta);
        } else {
            if (!respuesta.isEmpty()) {
                cbxRespuesta.setSelectedItem(respuesta);
            }
        }
    }

    private void mostrarTexto() {
        scrollPanel.setVisible(true);
        //cbxPanel.setVisible(false);
        cbxRespuesta.setVisible(false);
    }

    public void abrirCrrRespuestas () {

        JFrame frame = new JFrame("Responder ficha");
        frame.setContentPane(new CrrRespuestas().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350,200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
