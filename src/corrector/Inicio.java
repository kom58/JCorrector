package corrector;

import javax.swing.*;

public class Inicio {

    private  JPanel panPrincipal;
    private JTextField tflNombre;
    private JTextField tflContrasena;
    private JButton btnAceptar;
    private JLabel lblDia;
    private JLabel lblHora;
    private JLabel lblContrasena;
    private JLabel lblVersion;
    private int intentos = 0;


    public Inicio() {

        MetodosLib m = new MetodosLib();
        m.leerCrrIni();
        ponerFechaYHora();

        btnAceptar.addActionListener(e -> {

            intentos++;
            MetodosLib mtL = new MetodosLib();
            Datos dt = new Datos();
            dt.setUsuarioActual(tflNombre.getText());       // Almacena usuario en Datos
            if (mtL.esAdministrador(tflNombre.getText())) {
                tflContrasena.setVisible(true);             // Es administrador
                lblContrasena.setVisible(true);
                dt.setEsAdmin(true);                        // Almacena esAdmin en Datos
            } else {
                dt.setEsAdmin(false);                       //No es Administrador
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
                frame.dispose();                // Cierra Inicio
                if (dt.getFichaArranque().isEmpty()) {
                    abrirLaPortada();           // Abre la Portada siempre que no haya ficha de arranque
                }
                Correc crr = new Correc();
                crr.abrirCorrec();              // Abre Correc
            }

            if (dt.getEsAdmin()) {
                if (mtL.contrasenaAdmin(tflContrasena.getText())) {     // Contraseña correcta
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
                    frame.dispose();            // Cierra Inicio
                    if (dt.getFichaArranque().isEmpty()) {
                        abrirLaPortada();           // Abre la Portada siempre que no haya ficha de arranque
                    }
                    Correc crr = new Correc();
                    crr.abrirCorrec();           // Abre Correc
                } else if (intentos > 3 ) {
                    System.exit(0);        // Intento de entrada fraudulento
                }
            }

        });

    }

    private void ponerFechaYHora(){

        String fecha, hora;
        MetodosLib mLib = new MetodosLib();

        fecha = "Estamos a " + mLib.fechaActual();
        lblDia.setText(fecha);
        hora = "Son las " + mLib.horaActual();
        lblHora.setText(hora);

        lblVersion.setText("Versión " + mLib.versionCrr());
    }

    public void abrirLaPortada (){

        MetodosLib m = new MetodosLib();
        Datos dt = new Datos();

        String sistema = m.detectarSistemaOperativo();
        String rutaCorrector = m.directorioMWL(sistema);

        String  abrir = dt.getArchivoPortada();
        String ruta = rutaCorrector + "/med/" + abrir;

        m.abrirHTML(ruta, true);
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Corrector");
        frame.setContentPane(new Inicio().panPrincipal);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(580,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
