package corrector;

import javax.swing.*;

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

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbtMostrarErrores);
        grupo.add(rbtEjerCorrec);
        grupo.add(rbtControl);
        grupo.add(rbtInformePrMal);

        tflComandosIni.setText(d.getComandosInicioFch());
        cbxCalculadora.setSelected(d.getActivarCalcFch());
        cbxBloc.setSelected(d.getActivarBlocFch());
        cbxAyudaCrr.setSelected(d.getActivarAyudaCrrFch());
        cbxCrono.setSelected(d.getActivarCronoFch());
        ponerRadioSelecc();
        tflEmail.setText(d.getEnvioEmailFch());
        tflInforme.setText(d.getEnvioInformeFch());

        btnAnterior.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas3
            if (Integer.parseInt(d.getNumeroPreguntasFch()) == 0) {
                Fichas1 f1 = new Fichas1();
                f1.abrirFichas1();           // Abre Fichas1
            } else {
                Fichas2 f2 = new Fichas2();
                f2.abrirFichas2();           // Abre Fichas2
            }
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
        d.setTipoCorreccionFch(verRadioSelecc());
        d.setEnvioEmailFch(tflEmail.getText());
        d.setEnvioInformeFch(tflInforme.getText());
    }

    public String verRadioSelecc () {

        String seleccionado = "";

        if (rbtEjerCorrec.isSelected()) {
            seleccionado = "Correctos";
        } else if (rbtMostrarErrores.isSelected()) {
            seleccionado = "Errores";
        } else if (rbtInformePrMal.isSelected()) {
            seleccionado = "Informe";
        } else if (rbtControl.isSelected()) {
            seleccionado = "Control";
        }

        return seleccionado;

    }

    public void ponerRadioSelecc () {

        Datos d = new Datos();

        String tipo = d.getTipoCorreccionFch();

        if (tipo != "") {
            if (tipo.equals("Correctos")) {
                rbtEjerCorrec.setSelected(true);
            } else if (tipo.equals("Errores")) {
                rbtMostrarErrores.setSelected(true);
            } else if (tipo.equals("Informe")) {
                rbtInformePrMal.setSelected(true);
            } else if (tipo.equals("Control")) {
                rbtControl.setSelected(true);
            }
        }
    }

}
