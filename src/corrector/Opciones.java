package corrector;

import javax.swing.*;

public class Opciones {

    private JPanel panPrincipal;
    private JButton btnConfig;
    private JButton btnCerrar;
    private JButton abrirInformeButton;
    private JButton modificarFichaActualButton;
    private JButton btnFichaNueva;
    private JLabel lblAdmin;
    private JLabel lblPassw;
    private JLabel lblFondo;
    private JLabel lblError;
    private JLabel lblIdioma;
    private JLabel lblInforme;
    private JLabel lblArranque;
    private JLabel lblCarpeta;


    public Opciones() {

        Datos dt = new Datos();
        lblAdmin.setText(dt.getAdministrador());
        lblPassw.setText(dt.getContrasena());
        lblFondo.setText(dt.getArchivoPortada());
        lblError.setText(dt.getArchivoError());
        lblIdioma.setText(dt.getIdioma());
        lblInforme.setText(dt.getInforme());
        lblArranque.setText(dt.getFichaArranque());
        lblCarpeta.setText(dt.getCarpetaFichas());

        btnCerrar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();            // Cierra Opciones
            Correc crr = new Correc();
            crr.abrirCorrec();           // Abre Corrector
        });
        btnConfig.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();            // Cierra Opciones
            Configuracion conf = new Configuracion();
            conf.abrirConf();           // Abre Configuración
        });
        btnFichaNueva.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();            // Cierra Opciones
            Fichas1 f1 = new Fichas1();
            f1.abrirFichas1();           // Abre Fichas1
        });
    }

    public  void abrirOpciones() {
        JFrame frame = new JFrame("Opciones");
        frame.setContentPane(new Opciones().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
