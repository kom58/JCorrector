package corrector;

import javax.swing.*;

public class Opciones {

    private JPanel panPrincipal;
    private JButton btnConfig;
    private JButton btnCerrar;
    private JButton abrirInformeButton;
    private JButton modificarFichaActualButton;
    private JButton nuevaFichaButton;


    public Opciones() {
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
    }

    public  void abrirOpciones() {
        JFrame frame = new JFrame("Opciones");
        frame.setContentPane(new Opciones().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
