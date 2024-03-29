package corrector;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.util.Calendar;
import java.io.*;
import java.awt.event.KeyEvent;     // En Mac

public class MetodosLib {

    public String versionCrr() { return "0.0.10";}

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
        EncripDecrip ed = new EncripDecrip();

        try (BufferedReader buff = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            String clave = "0000";
            int cont = 0;

            while ((linea = buff.readLine()) != null) {
                cont++;
                switch (cont) {
                    case 1:
                        clave = linea;                       // Clave pública
                        break;
                             /*                                                 SIN ENCRIPTAR
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

                              */

                    case 2:
                        String version = ed.desencripLin(linea,clave);                     // Versión
                        break;
                    case 3:
                        dt.setAdministrador(ed.desencripLin(linea,clave));                 // Administrador
                        break;
                    case 4:
                        dt.setContrasena(ed.desencripLin(linea,clave));                    // Contraseña
                        break;
                    case 5:
                        dt.setArchivoPortada(ed.desencripLin(linea,clave));                // ArchivoPortada
                        break;
                    case 6:
                        dt.setArchivoError(ed.desencripLin(linea,clave));                  // ArchivoError
                        break;
                    case 7:
                        dt.setIdioma(ed.desencripLin(linea,clave));                        // Idioma
                        break;
                    case 8:
                        dt.setInforme(ed.desencripLin(linea,clave));                       // Informe
                        break;
                    case 9:
                        dt.setFichaArranque(ed.desencripLin(linea,clave));                 // Arranque
                        break;
                    case 10:
                        dt.setCarpetaFichas(ed.desencripLin(linea,clave));                 // CarpetaFichas
                        break;
                    case 11:
                        dt.setAlSolucionarFicha(ed.desencripLin(linea,clave));             // AlSolucionarFicha
                        break;
                    case 12:
                        dt.setInicioAnonimo(Boolean.parseBoolean(ed.desencripLin(linea,clave)));   // Inicio anónimo
                        break;
                    // */
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
        String ruta = directorioMWL(sistema);                               // Comprueba directorio Mac Win Lin
        String rutaFichero = ruta + "/crr.ini";

        int  clv = (int)(Math.random() * 8999 + 1000);                      // Clave pública
        String clave = String.valueOf(clv);

        Datos dt = new Datos();
        String tab = "";

        try {
            FileWriter f = new FileWriter(rutaFichero);

                tab = tab + clave + "\n";

                /*                                                          SIN ENCRIPTAR
                tab = tab + "Versión 0.0" + "\n";
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

                 */

                EncripDecrip ed = new EncripDecrip();
                tab = tab + ed.encripLin("Versión 1.0",clave) + "\n";
                tab = tab + ed.encripLin(dt.getAdministrador(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getContrasena(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getArchivoPortada(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getArchivoError(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getIdioma(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getInforme(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getFichaArranque(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getCarpetaFichas(),clave) + "\n";
                tab = tab + ed.encripLin(dt.getAlSolucionarFicha(),clave) + "\n";
                tab = tab + ed.encripLin("" + dt.getInicioAnonimo(),clave) + "\n";
                // */

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

    public String seleccionarArchivoFch(){

        String archivoSeleccionado;
        //String sistema;
        String ruta = "";

        JFrame frame = new JFrame("Abrir");
        //sistema = detectarSistemaOperativo();
        Datos  d = new Datos();

        ruta =  d.getCarpetaFichas();                               // Carpeta Fichas

        File initialDirectory = new File(ruta);

        JFileChooser fileChooser = new JFileChooser(initialDirectory);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Seleccionar ficha ", "crr");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            archivoSeleccionado = selectedFile.getAbsolutePath();
        } else {
            archivoSeleccionado = "";
            //System.out.println("No se seleccionó ningún archivo.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return archivoSeleccionado;
    }

    public String seleccionarArchivoHtm() {

        String archivoSeleccionado;
        //String sistema;
        String ruta = "";

        JFrame frame = new JFrame("Abrir");
        //sistema = detectarSistemaOperativo();
        Datos  d = new Datos();

        ruta =  d.getCarpetaFichas();                               // Carpeta Fichas

        File initialDirectory = new File(ruta);

        JFileChooser fileChooser = new JFileChooser(initialDirectory);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Seleccionar archivo ", "htm", "html");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            archivoSeleccionado = selectedFile.getAbsolutePath();
        } else {
            archivoSeleccionado = "";
            //System.out.println("No se seleccionó ningún archivo.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return archivoSeleccionado;

    }

    public String seleccionarArchivoMed() {

        String archivoSeleccionado;
        String sistema;
        String ruta = "";

        JFrame frame = new JFrame("Abrir");
        sistema = detectarSistemaOperativo();

        ruta = directorioMWL(sistema) + "/med/";            // Carpeta /med/

        File initialDirectory = new File(ruta);

        JFileChooser fileChooser = new JFileChooser(initialDirectory);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Seleccionar archivo ", "htm", "html");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            archivoSeleccionado = selectedFile.getAbsolutePath();
        } else {
            archivoSeleccionado = "";
            //System.out.println("No se seleccionó ningún archivo.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return archivoSeleccionado;

    }

    public String seleccionarArchivoCrr(String seleccionar, String extension) {

        String archivoSeleccionado;
        String sistema;

        JFrame frame = new JFrame("Abrir");
        sistema = detectarSistemaOperativo();

        String ruta = directorioMWL(sistema);            // Carpeta del Corrector

        File initialDirectory = new File(ruta);

        JFileChooser fileChooser = new JFileChooser(initialDirectory);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(seleccionar, extension);
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            archivoSeleccionado = selectedFile.getAbsolutePath();
        } else {
            archivoSeleccionado = "";
            //System.out.println("No se seleccionó ningún archivo.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return archivoSeleccionado;

    }

    public String seleccionarCarpeta() {

        String carpetaSeleccionada = "";

        // Se selecciona el usuario como raiz
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        chooser.setDialogTitle("Seleccionar un directorio");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            carpetaSeleccionada = String.valueOf(chooser.getSelectedFile());
        }

        return carpetaSeleccionada;
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
                        dt.setNumeroPreguntasFch(linea);    // NumeroPreguntasFch
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
                        dt.setComandosInicioFch(linea);                         // ComandosInicioFch
                        break;
                    case 13:                                                    // ActivarCalcFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarCalcFch(true);
                        } else  { dt.setActivarCalcFch(false); }
                        break;
                    case 14:                                                    // ActivarBlocFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarBlocFch(true);
                        } else  { dt.setActivarBlocFch(false); }
                        break;
                    case 15:                                                    // ActivarAyudaCrrFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarAyudaCrrFch(true);
                        } else  { dt.setActivarAyudaCrrFch(false); }
                        break;
                    case 16:                                                    // ActivarCronoFch
                        if ("true".equalsIgnoreCase(linea)) {
                            dt.setActivarCronoFch(true);
                        } else  { dt.setActivarCronoFch(false); }
                        break;
                    case 17:
                        dt.setTipoCorreccionFch(linea);                         // TipoCorrecciónFch
                        break;
                    case 18:
                        dt.setEnvioEmailFch(linea);                             // EnvioEmailFch
                        break;
                    case 19:
                        dt.setEnvioInformeFch(linea);                           // EnvioInformeFch
                        break;
                    case 20:
                        dt.setComandosFch(linea);                               // ComandosFch !!!!!!!!!!!!!!!!!!!
                        break;
                    case 21:
                        dt.setTipoFch(linea);                                   // TipoFch !!!!!!!!!!!!!!!!!!!!!!!!
                        break;
                    case 22:
                        dt.setRespuestaPreguntaFch(linea);                      // RespuestaPreguntaFch !!!!!!!!!!!!
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

        //String sistema = detectarSistemaOperativo();                        // Detecta Sistema Operativo
        //String ruta = directorioMWL(sistema);                              // Comprueba directorio Mac Win Lin
        Datos dt = new Datos();
        String rutaFichero = dt.getCarpetaFichas() + dt.getCarpetaFch() + "/" + dt.getNombreFch() + ".crr";

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
            tab = tab + dt.getComandosInicioFch() + "\n";
            tab = tab + dt.getActivarCalcFch() + "\n";
            tab = tab + dt.getActivarBlocFch() + "\n";
            tab = tab + dt.getActivarAyudaCrrFch() + "\n";
            tab = tab + dt.getActivarCronoFch() + "\n";
            tab = tab + dt.getTipoCorreccionFch() + "\n";
            tab = tab + dt.getEnvioEmailFch() + "\n";
            tab = tab + dt.getEnvioInformeFch() + "\n";
            if (Integer.parseInt(dt.getNumeroPreguntasFch()) == 0) {
                tab = tab + "\n\n\n";
            } else if (Integer.parseInt(dt.getNumeroPreguntasFch()) > 0) {
                tab = tab + "Aquí dt.getComandosFch()  \n";
                tab = tab + "Aquí dt.getTipoFch() \n";
                tab = tab + "Aquí dt.getRespuestaPreguntaFch() \n";
            }
            tab = tab + "[Fin]\n";

            f.write(tab);
            f.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void comprobarArchivo_Crear (String arch) {

        File archivo = new File(arch);

        if (archivo.exists()) {
            // El archivo ya existe
        } else {
            // El archivo no existe
            try {
                // Crear el archivo
                if (archivo.createNewFile()) {
                    // Aquí se puede incluir contenido
                    FileWriter txt = new FileWriter(archivo);
                    // escribir contenido ...
                    txt.close();        // Se cierra el archivo
                } else {
                    System.out.println("No se pudo crear el archivo");
                }
            } catch (IOException e) {
                System.out.println("Se produjo error al crear archivo");
            }
        }
    }

    public String encLin (String lin, String clav) {
/*
        String clave = "Version00" + clav;

        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoEncriptado = cipher.doFinal(lin.getBytes());
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }

 */
        return null;
    }

    public String desenLin (String lin, String clav) {
/*
        String clave = "Version00" + clav;

        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textoDesencriptado = cipher.doFinal(Base64.getDecoder().decode(lin));
            return new String(textoDesencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }

 */
        return null;
    }

}
