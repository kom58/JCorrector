package corrector;

import javax.swing.JFrame;
import java.awt.*;
import java.util.Calendar;
import java.io.*;
import java.awt.event.KeyEvent;     // En Mac
//import java.awt.Window;             // En Windows

public class MetodosLib {
    private int diaA, mesA, anoA;
    private int horaA, minA;


    public String versionCrr() {
        return "0.0.3";
    }

    public String fechaActual() {

        String fechaAc;
        Calendar ahora = Calendar.getInstance();
        diaA = ahora.get(Calendar.DAY_OF_MONTH);
        mesA = ahora.get(Calendar.MONTH) + 1;
        anoA = ahora.get(Calendar.YEAR);

        fechaAc = String.format("%02d.%02d.%04d", diaA, mesA, anoA);

        return fechaAc;
    }

    public String horaActual() {

        String horaAc;
        Calendar ahora = Calendar.getInstance();
        horaA = ahora.get(Calendar.HOUR_OF_DAY);
        minA = ahora.get(Calendar.MINUTE);

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

        File d = null;                                      // Comprueba y crea directorios
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

                tab = tab + "0000\n";
                tab = tab + "Versión 0.0\n";
                tab = tab + dt.getAdministrador() + "\n";
                tab = tab + dt.getContrasena() + "\n";
                tab = tab + dt.getArchivoPortada() + "\n";
                tab = tab + dt.getArchivoError() + "\n";
                tab = tab + dt.getIdioma() + "\n";
                tab = tab + dt.getInforme() + "\n";
                tab = tab + dt.getFichaArranque() + "\n";
                tab = tab + dt.getCarpetaFichas() + "\n";

                f.write(tab);
                f.close();

        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void abrirHTML (String archHtml) {

        String sistema = detectarSistemaOperativo();        // Detecta Sistema Operativo
        String ruta = directorioMWL(sistema);               // Comprueba directorio Mac Win Lin
        String rutaFichero = ruta + archHtml;               // Ruta de la página HTML
        //String rutaError = ruta + "med/Error.htm";        // Ruta de página Error

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


              /*  // Declara la variable activeWindow y obtener ventana activa
                Window activeWindow = null;
                if (sistema == "win") {
                    activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
                }

                // Abre la página HTML en el navegador predeterminado
                Desktop.getDesktop().browse(htmlFile.toURI());

                // Intenta devolver el foco al formulario Java
                if (activeWindow != null) {
                    activeWindow.toFront();
                }
               */

            }
        }
        //catch (IOException e) {e.printStackTrace(); }
        //catch (AWTException e) {throw new RuntimeException(e); }
        catch (IOException | InterruptedException | java.awt.AWTException e) {
            e.printStackTrace();
        }

    }

    public String detectarSistemaOperativo (){

        String sistema ="";
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



}
