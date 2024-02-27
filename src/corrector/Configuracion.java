package corrector;

import javax.swing.*;

public class Configuracion {
    private JPanel panPrincipal;
    private JButton btnCerrar;
    private JButton btnGuardar;
    private JLabel lblDia;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel lblVersion;
    private JButton btnCambiarPasw;
    private JButton button1;
    private JButton btnCrearInf;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public Configuracion() {

        MetodosLib mLib = new MetodosLib();
        lblDia.setText("Estamos a " + mLib.fechaActual());
        lblVersion.setText("Versión " + mLib.versionCrr());

        btnCerrar.addActionListener(e -> System.exit(0));
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Configuracion");
        frame.setContentPane(new Configuracion().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(750,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


}
