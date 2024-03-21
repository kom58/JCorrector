package corrector;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class Fichas1 {

    private JPanel panPrincipal;
    private JButton btnCancelar;
    private JButton btnSiguiente;
    private JTextField tflNombre;
    private JTextField tflArchInicial;
    private JTextField tflArchAyuda;
    private JComboBox cbxNumPreg;
    private JComboBox cbxArea;
    private JComboBox cbxNivel;
    private JComboBox cbxCurso;
    private JTextField tflTema;
    private JButton btnArchInicial;
    private JButton btnArchAyuda;
    private JCheckBox chbEsFchConsulta;

    public Fichas1() {

        Datos d = new Datos();
        tflNombre.setText(d.getNombreFch());
        tflArchInicial.setText(d.getArchivoInicialFch());
        tflArchAyuda.setText(d.getArchivoAyudaFch());
        cbxNumPreg.setSelectedItem(d.getNumeroPreguntasFch());
        chbEsFchConsulta.setSelected(d.getEsDeConsultaFch());
        cbxNivel.setSelectedItem(d.getNivelFch());
        cbxCurso.setSelectedItem(d.getCursoFch());
        cbxArea.setSelectedItem(d.getAreaFch());
        tflTema.setText(d.getTemaFch());

        btnCancelar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
            frame.dispose();                // Cierra Fichas1
            Opciones opc = new Opciones();
            opc.abrirOpciones();           // Abre Opciones
        });
        btnSiguiente.addActionListener(e -> {
                                            // Comprueba no vacío el Nombre de la ficha ni ArchInicial
            if ((!tflNombre.getText().isEmpty()) && (!tflArchInicial.getText().isEmpty())){
                guardarDatosFichas1();             // Guarda datos Fichas 1
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panPrincipal);
                frame.dispose();                // Cierra Fichas1

                if (cbxNumPreg.getSelectedItem().equals("0")) {
                    Fichas3 f3 = new Fichas3();
                    f3.abrirFichas3();           // Abre Fichas3
                } else {
                    Fichas2 f2 = new Fichas2();
                    f2.abrirFichas2();           // Abre Fichas2
                }

            }
        });
        btnArchInicial.addActionListener(e -> {

            MetodosLib m = new MetodosLib();
            Datos dt = new Datos();

            String fichaInicial;
            String fichaSinDir;
            fichaInicial = m.seleccionarArchivoHtm();

            if (!fichaInicial.isEmpty()) {
                fichaSinDir = fichaInicial.replace(dt.getCarpetaFichas(),"");
                tflArchInicial.setText(fichaSinDir);
            }
        });
        btnArchAyuda.addActionListener(e -> {

            MetodosLib m = new MetodosLib();
            Datos dt = new Datos();

            String fichaAyuda;
            String fichaSinDir;
            fichaAyuda = m.seleccionarArchivoHtm();

            if (!fichaAyuda.isEmpty()) {
                fichaSinDir = fichaAyuda.replace(dt.getCarpetaFichas(),"");
                tflArchAyuda.setText(fichaSinDir);
            }

        });
        chbEsFchConsulta.addActionListener(e -> {
            if (chbEsFchConsulta.isSelected()) {
                cbxNumPreg.setSelectedItem("0");
                cbxNumPreg.setEnabled(false);
            } else {
                cbxNumPreg.setEnabled(true);
            }
        });
        cbxNumPreg.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = cbxNumPreg.getSelectedItem().toString();
                if ("0".equals(selectedItem)) {
                    chbEsFchConsulta.setSelected(true);
                }
            }
        });
    }

    public void abrirFichas1() {
        String tituloForm = "Asistente para la corrección de fichas: Paso 1 de 3 (FICHA)";
        JFrame frame = new JFrame(tituloForm);
        frame.setContentPane(new Fichas1().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(780,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void guardarDatosFichas1() {

            Datos d = new Datos();
            d.setNombreFch(tflNombre.getText());
            d.setArchivoInicioFch(tflArchInicial.getText());
            d.setArchivoAyudaFch(tflArchAyuda.getText());
            d.setNumeroPreguntasFch((String) cbxNumPreg.getSelectedItem());
            d.setEsDeConsultaFch(chbEsFchConsulta.isSelected());
            d.setNivelFch((String) cbxNivel.getSelectedItem());
            d.setCursoFch((String) cbxCurso.getSelectedItem());
            d.setAreaFch((String) cbxArea.getSelectedItem());
            d.setTemaFch(tflTema.getText());
    }
}
