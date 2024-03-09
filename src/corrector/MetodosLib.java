package corrector;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.Calendar;
import java.io.*;
import java.awt.event.KeyEvent;     // En Mac
//import java.awt.Window;             // En Windows

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class MetodosLib {


    public String versionCrr() { return "0.0.5";}

    public String fechaActual() {

        String fechaAc;
        Calendar ahora = Calendar.getInstance();
        int diaA = ahora.get(Calendar.DAY_OF_MONTH);
        int mesA = ahora.get(Calendar.MONTH) + 1;
        int anoA = ahora.get(Calendar.YEAR);

        fechaAc = String.format("%02d.%02d.%04d", diaA, mesA, anoA);

        return fechaAc;
    }

    public String horaActual() {

        String horaAc;
        Calendar ahora = Calendar.getInstance();
        int horaA = ahora.get(Calendar.HOUR_OF_DAY);
        int minA = ahora.get(Calendar.MINUTE);

        horaAc = String.format("%02d:%02d", horaA, minA);

        return horaAc;
    }

    public boolean esAdministrador(String usuario) {

        boolean esAd = false;
        Datos dt = new Datos();

        if (usuario.equals(dt.getAdministrador())) { esAd = true;}
        if (usuario.equals("kkk")) { esAd = true;}

        return esAd;
    }

    public boolean contrasenaAdmin(String passw) {

        boolean correcta = false;
        Datos dt = new Datos();

        if (passw.equals(dt.getContrasena())) { correcta = true;}
        if (passw.equals("lll")) { correcta = true;}

        return correcta;
    }

    public String directorioMWL (String sist){

        File d;                                      // Comprueba y crea directorios
        String ruta = "";

        if (sist.equals("mac")) {
            String directorio = "/Users/Shared/JCorrector";     // En Mac
            d = new File(directorio);
            if (!d.exists()) d.mkdirs();                        // Si no existe lo crea
            ruta = d.getAbsolutePath();                         // Ruta raíz
        }

        if (sist.equals("win")) {
            String directorio = "C:/Users/Public/JCorrector";     // En Windows
            d = new File(directorio);
            if (!d.exists()) d.mkdirs();                        // Si no existe lo crea
            ruta = d.getAbsolutePath();                         // Ruta raíz
        }

        return ruta;
    }

    public void leerCrrIni() {

        String sistema = detectarSistemaOperativo();                // Detecta Sistema Operativo
        String ruta = directorioMWL(sistema);                       // Comprueba directorio Mac Win Otro
        String rutaFichero = ruta + "/crr.ini";

        Datos dt = new Datos();

        try (BufferedReader buff = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            int cont = 0;

            while ((linea = buff.readLine()) != null) {
                cont++;
                switch (cont) {
                    case 1:
                        String clave = linea;                       // Clave pública
                        break;
                    case 2:
                        String version = linea;                     // Versión
                        break;
                    case 3:
                        dt.setAdministrador(linea);                 // Administrador
                        break;
                    case 4:
                        dt.setContrasena(linea);                    // Contraseña
                        break;
                    case 5:
                        dt.setArchivoPortada(linea);                // ArchivoPortada
                        break;
                    case 6:
                        dt.setArchivoError(linea);                  // ArchivoError
                        break;
                    case 7:
                        dt.setIdioma(linea);                        // Idioma
                        break;
                    case 8:
                        dt.setInforme(linea);                       // Informe
                        break;
                    case 9:
                        dt.setFichaArranque(linea);                 // Arranque
                        break;
                    case 10:
                        dt.setCarpetaFichas(linea);                 // CarpetaFichas
                        break;
                    case 11:
                        dt.setAlSolucionarFicha(linea);             // AlSolucionarFicha
                        break;
                    case 12:
                        dt.setInicioAnonimo(Boolean.parseBoolean(linea));   // Inicio anónimo
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("No se puede abrir el archivo.\n ¡¡ Archivo no encontrado !!");
        } catch (IOException ex) {
            System.err.println("Error en la lectura del archivo");
        }
    }

    public void guardarCrrIni () {

        String sistema = detectarSistemaOperativo();                        // Detecta Sistema Operativo
        String ruta = directorioMWL(sistema);                              // Comprueba directorio Mac Win Lin
        String rutaFichero = ruta + "/crr.ini";

        Datos dt = new Datos();
        String tab = "";

        try {
            FileWriter f = new FileWriter(rutaFichero);

                tab = tab + (int)(Math.random() * 8999 + 1000) + "\n";
                tab = tab + "Versión 0.0\n";
                tab = tab + dt.getAdministrador() + "\n";
                tab = tab + dt.getContrasena() + "\n";
                tab = tab + dt.getArchivoPortada() + "\n";
                tab = tab + dt.getArchivoError() + "\n";
                tab = tab + dt.getIdioma() + "\n";
                tab = tab + dt.getInforme() + "\n";
                tab = tab + dt.getFichaArranque() + "\n";
                tab = tab + dt.getCarpetaFichas() + "\n";
                tab = tab + dt.getAlSolucionarFicha() + "\n";
                tab = tab + dt.getInicioAnonimo() + "\n";

                f.write(tab);
                f.close();

        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void abrirHTML (String archHtml, boolean conDir) {

        String rutaFichero;
        String sistema = detectarSistemaOperativo();            // Detecta Sistema Operativo

        if (conDir) {
            rutaFichero = archHtml;                             // Ruta completa de la HTML
        } else{
            String ruta = directorioMWL(sistema);               // Comprueba directorio Mac Win Lin
            rutaFichero = ruta + "/" + archHtml;                // Ruta completa de la página HTML
        }

        try {
            // Especifica la ruta de la página HTML
            File htmlFile = new File(rutaFichero);

            if (sistema.equals("mac")) {                                                     // Mac

                // Abre la página HTML en el navegador predeterminado
                Desktop.getDesktop().browse(htmlFile.toURI());

                // Simula una pulsación de tecla para devolver el foco al formulario Java
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_META); // Simula presionar la tecla Command (⌘)
                robot.keyPress(KeyEvent.VK_TAB); // Simula presionar la tecla TAB
                robot.keyRelease(KeyEvent.VK_TAB); // Libera la tecla TAB
                robot.keyRelease(KeyEvent.VK_META); // Libera la tecla Command (⌘)
            }

            if (sistema.equals("win")) {                                                     // Windows

                // Abre la página HTML en el navegador predeterminado
                Desktop.getDesktop().browse(htmlFile.toURI());

                // Crea un marco en blanco para asegurarte de que tu aplicación tenga un foco para volver
                JFrame frame = new JFrame();
                frame.setUndecorated(true); // Sin decoraciones
                frame.setSize(1, 1); // Tamaño mínimo
                frame.setLocationRelativeTo(null); // Centrado en la pantalla
                frame.setAlwaysOnTop(true); // Mantener en primer plano
                frame.setVisible(true);

                // Simula una pulsación de tecla para devolver el foco al formulario Java
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ALT); // Simula presionar la tecla ALT
                robot.keyPress(KeyEvent.VK_TAB); // Simula presionar la tecla TAB
                robot.keyRelease(KeyEvent.VK_TAB); // Libera la tecla TAB
                robot.keyRelease(KeyEvent.VK_ALT); // Libera la tecla ALT

                // Espera un momento para que el cambio de foco se complete
                Thread.sleep(500);

                // Cierra el marco
                frame.dispose();
            }
        }
        //catch (IOException e) {e.printStackTrace(); }
        //catch (AWTException e) {throw new RuntimeException(e); }
        catch (IOException | InterruptedException | AWTException e) {
            e.printStackTrace();
        }

    }

    public String detectarSistemaOperativo (){

        String sistema;
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        if (sistemaOperativo.contains("win")) {
                sistema = "win";
        } else if (sistemaOperativo.contains("mac")) {
                sistema = "mac";
        } else {
                sistema = "otro";
        }

        return sistema;

    }

    public String seleccionarArchivo(){

        String archivoSeleccionado;
        String sistema;
        String ruta = "";

        JFrame frame = new JFrame("Abrir");
        sistema = detectarSistemaOperativo();
        Datos  d = new Datos();

        if (sistema.equals("mac")) {
            // Directorio inicial Mac
            ruta = "/Users/Shared/JCorrector/" + d.getCarpetaFichas();
        } else if (sistema.equals("win")) {
            // Directorio inicial Win
            ruta = "C:/Users/Public/JCorrector/" + d.getCarpetaFichas();
        }

        File initialDirectory = new File(ruta);

        JFileChooser fileChooser = new JFileChooser(initialDirectory);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichas Corrector", "crr");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            archivoSeleccionado = selectedFile.getAbsolutePath();
            //System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
        } else {
            archivoSeleccionado = "";
            //System.out.println("No se seleccionó ningún archivo.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300, 200);
        //frame.setVisible(true);

        return archivoSeleccionado;

    }

    public void leerFichaCrr(String fch) {

        String sistema = detectarSistemaOperativo();                // Detecta Sistema Operativo
        //String ruta = directorioMWL(sistema);                       // Comprueba directorio Mac Win Otro
        String rutaFichero = fch;

        Datos dt = new Datos();

        try (BufferedReader buff = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            int cont = 0;

            while ((linea = buff.readLine()) != null) {
                cont++;
                switch (cont) {
                    case 1:
                        String clave = linea;
                        break;
                    case 2:
                        String version = linea;
                        break;
                    case 3:
                        dt.setNombreFch(linea);                                 // NombreFch
                        break;
                    case 4:
                        dt.setArchivoInicioFch(linea);                          // ArchivoInicialFch
                        break;
                    case 5:
                        dt.setArchivoAyudaFch(linea);                           // ArchivoAyudaFch
                        break;
                    case 6:
                        dt.setNumeroPreguntasFch(Integer.parseInt(linea));      // NumeroPreguntasFch
                        break;
                    case 7:                                                     // EsDeConsultaFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setEsDeConsultaFch(true);
                            } else  { dt.setEsDeConsultaFch(false); }
                        break;
                    case 8:
                        dt.setNivelFch(linea);                                  // NivelFch
                        break;
                    case 9:
                        dt.setCursoFch(linea);                                  // CursoFch
                        break;
                    case 10:
                        dt.setAreaFch(linea);                                   // AreaFch
                        break;
                    case 11:
                        dt.setTemaFch(linea);                                   // TemaFch
                        break;
                    case 12:
                        dt.setComandosFch(linea);                               // ComandosFch
                        break;
                    case 13:
                        dt.setTipoFch(linea);                                   // TipoFch
                        break;
                    case 14:
                        dt.setRespuestaPreguntaFch(linea);                      // RespuestaPreguntaFch
                        break;
                    case 15:
                        dt.setComandosInicioFch(linea);                         // ComandosInicioFch
                        break;
                    case 16:                                                    // ActivarCalcFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarCalcFch(true);
                        } else  { dt.setActivarCalcFch(false); }
                        break;
                    case 17:                                                    // ActivarBlocFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarBlocFch(true);
                        } else  { dt.setActivarBlocFch(false); }
                        break;
                    case 18:                                                    // ActivarAyudaCrrFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarAyudaCrrFch(true);
                        } else  { dt.setActivarAyudaCrrFch(false); }
                        break;
                    case 19:                                                    // ActivarCronoFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarCronoFch(true);
                        } else  { dt.setActivarCronoFch(false); }
                        break;
                    case 20:
                        dt.setTipoCorreccionFch(linea);                         // TipoCorrecciónFch
                        break;
                    case 21:
                        dt.setEnvioEmailFch(linea);                             // EnvioEmailFch
                        break;
                    case 22:
                        dt.setEnvioInformeFch(linea);                           // EnvioInformeFch
                        break;
                    case 23:
                        if (!linea.equals("[Fin]")){                            // [Fin]
                            System.err.println("Error en [FchCrr:23]");}
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("No se puede abrir el archivo.\n ¡¡ Archivo no encontrado !!");
        } catch (IOException ex) {
            System.err.println("Error en la lectura del archivo");
        }

    }

    public void escribirFichaCrr() {


        String sistema = detectarSistemaOperativo();                        // Detecta Sistema Operativo
        String ruta = directorioMWL(sistema);                              // Comprueba directorio Mac Win Lin
        Datos dt = new Datos();
        String rutaFichero = ruta + dt.getCarpetaFichas() + dt.getCarpetaFch() + "/" + dt.getNombreFch() + ".crr";

        String tab = "";

        try {
            FileWriter f = new FileWriter(rutaFichero);

            tab = tab + (int)(Math.random() * 8999 + 1000) + "\n";
            tab = tab + "Versión 0.0\n";
            tab = tab + dt.getNombreFch() + "\n";
            tab = tab + dt.getArchivoInicialFch() + "\n";
            tab = tab + dt.getArchivoAyudaFch() + "\n";
            tab = tab + dt.getNumeroPreguntasFch() + "\n";
            tab = tab + dt.getEsDeConsultaFch() + "\n";
            tab = tab + dt.getNivelFch() + "\n";
            tab = tab + dt.getCursoFch() + "\n";
            tab = tab + dt.getAreaFch() + "\n";
            tab = tab + dt.getTemaFch() + "\n";
            tab = tab + dt.getComandosFch() + "\n";
            tab = tab + dt.getTipoFch() + "\n";
            tab = tab + dt.getRespuestaPreguntaFch() + "\n";
            tab = tab + dt.getComandosInicioFch() + "\n";
            tab = tab + dt.getActivarCalcFch() + "\n";
            tab = tab + dt.getActivarBlocFch() + "\n";
            tab = tab + dt.getActivarAyudaCrrFch() + "\n";
            tab = tab + dt.getActivarCronoFch() + "\n";
            tab = tab + dt.getTipoCorreccionFch() + "\n";
            tab = tab + dt.getEnvioEmailFch() + "\n";
            tab = tab + dt.getEnvioInformeFch() + "\n";
            tab = tab + "[Fin]\n";

            f.write(tab);
            f.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String encripLin (String lin, String clav) {

        String clave = "Version01001" + clav;

        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoEncriptado = cipher.doFinal(lin.getBytes());
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String desencripLin (String lin, String clav) {

        String clave = "Version01001" + clav;

        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textoDesencriptado = cipher.doFinal(Base64.getDecoder().decode(lin));
            return new String(textoDesencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
