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
    private JButton button2;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JTextField tflInicial;
    private JButton cambiarButton;
    private JTextField tflPassw;
    private JTextField tflAdmin;
    private JTextField tflArranque;
    private JTextField tflFondo;
    private JTextField tflError;
    private JTextField tflIdioma;
    private JTextField tflInforme;
    private JButton crearButton;
    private JComboBox comboBox1;
    private JCheckBox síCheckBox;

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

        MetodosLib mLib = new MetodosLib();
        lblDia.setText("Estamos a " + mLib.fechaActual());
        lblVersion.setText("Versión " + mLib.versionCrr());

        btnCerrar.addActionListener(e ->  {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Configuración
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Datos dt = new Datos();
                dt.setAdministrador(tflAdmin.getText());
                dt.setContrasena(tflPassw.getText());
                dt.setArchivoPortada(tflFondo.getText());
                dt.setArchivoError(tflError.getText());
                dt.setIdioma(tflIdioma.getText());
                dt.setInforme(tflInforme.getText());
                dt.setFichaArranque(tflArranque.getText());
                dt.setCarpetaFichas(tflInicial.getText());

                MetodosLib m = new MetodosLib();
                m.guardarCrrIni();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
                frame.dispose();                // Cierra Configuración
                Opciones opc = new Opciones();
                opc.abrirOpciones();           // Abre Opciones

            }
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


}
