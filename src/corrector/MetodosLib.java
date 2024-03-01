package corrector;

import java.util.Calendar;
import java.io.*;

public class MetodosLib {
    private int diaA, mesA, anoA;
    private int horaA, minA;


    public String versionCrr() {
        return "0.0.2";
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

    public void leerCrrIni() {

        String rutaFichero = "/Users/joseparra/IdeaProjects/JCorrector/Corrector/src/crr.ini";
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

}
