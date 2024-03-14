package corrector;

import javax.swing.*;

public class CrrRespuestas {
    private JPanel panPrincipal;
    private JButton btnFinalizar;
    private JButton btnSiguiente;
    private JButton btnAnterior;
    private JTextArea tarRespuesta;
    private JLabel lblRespuesta;
    private JLabel lblTiempo;
    private JLabel lblPreg;
    private JLabel lblNumPreg;

    public CrrRespuestas() {
        btnFinalizar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                    // Cierra CrrRespuestas
            Correc cr = new Correc();
            cr.abrirCorrec();                   // Abre Correc
        });
    }

    public void abrirCrrRespuestas () {

        JFrame frame = new JFrame("Opciones");
        frame.setContentPane(new CrrRespuestas().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350,200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
