package corrector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configuracion {
    private JPanel panPrincipal;
    private JButton btnCerrar;
    private JButton btnGuardar;
    private JLabel lblDia;
    private JLabel lblVersion;
    private JButton btnCarpetaIni;
    private JButton btnFchArranque;
    private JButton btnArchFondo;
    private JButton btnArchError;
    private JButton btnIdioma;
    private JTextField tflInicial;
    private JButton btnCambiarPass;
    private JTextField tflPassw;
    private JTextField tflAdmin;
    private JTextField tflArranque;
    private JTextField tflFondo;
    private JTextField tflError;
    private JTextField tflIdioma;
    private JTextField tflInforme;
    private JButton btnCrearInforme;
    private JComboBox cbxAlSolucionar;
    private JCheckBox chbInicioAnonim;

    public Configuracion() {

        Datos dt = new Datos();
        tflAdmin.setText(dt.getAdministrador());
        tflPassw.setText(dt.getContrasena());
        tflInicial.setText(dt.getCarpetaFichas());
        tflArranque.setText(dt.getFichaArranque());
        tflFondo.setText(dt.getArchivoPortada());
        tflError.setText(dt.getArchivoError());
        tflIdioma.setText(dt.getIdioma());
        tflInforme.setText(dt.getInforme());
        cbxAlSolucionar.setSelectedItem(dt.getAlSolucionarFicha());
        chbInicioAnonim.setSelected(dt.getInicioAnonimo());

        MetodosLib mLib = new MetodosLib();
        lblDia.setText("Estamos a " + mLib.fechaActual());
        lblVersion.setText("Versión " + mLib.versionCrr());

        btnCerrar.addActionListener(e ->  {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Configuración
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
        btnGuardar.addActionListener(e -> {

           guardarConfiguracion();          // Guarda Configuración

            MetodosLib m = new MetodosLib();
            m.guardarCrrIni();              // Escribe CrrIni

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Configuración
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
        btnCarpetaIni.addActionListener(e -> {

            MetodosLib m = new MetodosLib();
            Datos d = new Datos();

            String carpetaSeleccionada;
            carpetaSeleccionada = m.seleccionarCarpeta();

            tflInicial.setText(carpetaSeleccionada);

            //m.leerFichaCrr(fichaSeleccionada);                      // Lee Crr de la Fch

            //d.setFichaActiva(d.getArchivoInicialFch());           // Guarda FichaActiva

            //String carpFchasyFichaAct = d.getCarpetaFichas() + d.getFichaActiva();

            //if  (!d.getFichaActiva().isEmpty()) {
                //m.abrirHTML(carpFchasyFichaAct, false);
            //}

        });
    }

    public  void abrirConf() {
        JFrame frame = new JFrame("Configuracion");
        frame.setContentPane(new Configuracion().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(780,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void guardarConfiguracion() {

        Datos dt = new Datos();
        dt.setAdministrador(tflAdmin.getText());
        dt.setContrasena(tflPassw.getText());
        dt.setArchivoPortada(tflFondo.getText());
        dt.setArchivoError(tflError.getText());
        dt.setIdioma(tflIdioma.getText());
        dt.setInforme(tflInforme.getText());
        dt.setFichaArranque(tflArranque.getText());
        dt.setCarpetaFichas(tflInicial.getText());
        dt.setAlSolucionarFicha((String) cbxAlSolucionar.getSelectedItem());
        dt.setInicioAnonimo(chbInicioAnonim.isSelected());
    }

}
