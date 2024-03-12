package corrector;

import javax.swing.*;

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

            if (!carpetaSeleccionada.equals("")) {
                tflInicial.setText(carpetaSeleccionada);
                d.setCarpetaFichas(carpetaSeleccionada);
            }
        });
        btnFchArranque.addActionListener(e -> {

            MetodosLib m = new MetodosLib();
            Datos d = new Datos();

            String fichaArranque;
            String fichaSinDir;
            fichaArranque = m.seleccionarArchivoFch();


            if (!fichaArranque.equals("")) {
                fichaSinDir = fichaArranque.replace(d.getCarpetaFichas(),"");
                tflArranque.setText(fichaSinDir);
            }
        });
        btnArchFondo.addActionListener(e -> {

            MetodosLib m = new MetodosLib();

            String archivoFondo;
            String archivoSinDir;

            archivoFondo = m.seleccionarArchivoMed();

            if (!archivoFondo.equals("")) {
                String sistema = m.detectarSistemaOperativo();
                String rutaCrrMed = m.directorioMWL(sistema) + "/med/";
                archivoSinDir = archivoFondo.replace(rutaCrrMed,"");
                tflFondo.setText(archivoSinDir);
            }
        });
        btnArchError.addActionListener(e -> {

            MetodosLib m = new MetodosLib();

            String archivoError;
            String archivoSinDir;

            archivoError = m.seleccionarArchivoMed();

            if (!archivoError.equals("")) {
                String sistema = m.detectarSistemaOperativo();
                String rutaCrrMed = m.directorioMWL(sistema) + "/med/";
                archivoSinDir = archivoError.replace(rutaCrrMed,"");
                tflError.setText(archivoSinDir);
            }
        });
        btnIdioma.addActionListener(e -> {

            MetodosLib m = new MetodosLib();

            String archivoIdioma;
            String archivoSinDir;

            archivoIdioma = m.seleccionarArchivoCrr("Seleccionar idioma ", "lng");

            if (!archivoIdioma.equals("")) {
                String sistema = m.detectarSistemaOperativo();
                String rutaCrr = m.directorioMWL(sistema) + "/";
                archivoSinDir = archivoIdioma.replace(rutaCrr, "");
                tflIdioma.setText(archivoSinDir);
            }
        });
        btnCrearInforme.addActionListener(e -> {

            if (!tflInforme.getText().equals("")) {
                MetodosLib m = new MetodosLib();

                String sistema = m.detectarSistemaOperativo();
                String dirSistema = m.directorioMWL(sistema);
                String archivoInforme = dirSistema + "/" + tflInforme.getText() + ".lgx";

                m.comprobarArchivo_Crear(archivoInforme);
            }
        });
        btnCrearInforme.addActionListener(e -> {



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
