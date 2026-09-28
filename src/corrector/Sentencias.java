package corrector;

public class Sentencias {

    public boolean leerComando1(String texto, String cmd) {

        boolean estaCom = false;

        if (texto.contains(cmd)) {
            estaCom = true;
        }

        return estaCom;
    }

    public String leerComando2(String texto, String inicio, String fin) {

        int posInicio = texto.indexOf(inicio);
        int posFin = texto.indexOf(fin);

        if (posInicio != -1 && posFin != -1 && posFin > posInicio) {
            return texto.substring(posInicio + inicio.length(), posFin).trim();
        }

        return "";
    }

    public boolean analizaRespExacta(String posiblesResp, String respUsuario, String comandosPrg) {

        boolean estaBien = false;

        if (leerComando1(comandosPrg.toUpperCase(), "SIM")) {
                                                                    //Controlar mayúsculas y minúsculas
        } else {
            posiblesResp = posiblesResp.toUpperCase();              // No controlar
            respUsuario = respUsuario.toUpperCase();
        }
        if (posiblesResp.contains(respUsuario)) {
            estaBien = true;
        }

        return estaBien;
    }



}
