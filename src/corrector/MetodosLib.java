package corrector;

import java.util.Calendar;

public class MetodosLib {
    private int diaA, mesA, anoA;
    private int horaA, minA;


    public String versionCrr() {return "0.0.1";}

    public String fechaActual(){

        String fechaAc = "01.01.2000";
        Calendar ahora = Calendar.getInstance();
        diaA = ahora.get(Calendar.DAY_OF_MONTH);
        mesA = ahora.get(Calendar.MONTH) + 1;
        anoA = ahora.get(Calendar.YEAR);

        fechaAc = String.format("%02d.%02d.%04d", diaA , mesA , anoA);

        return fechaAc;
    }

    public String horaActual(){

        String horaAc = "00:00";
        Calendar ahora = Calendar.getInstance();
        horaA = ahora.get(Calendar.HOUR_OF_DAY);
        minA = ahora.get(Calendar.MINUTE);

        horaAc = String.format("%02d:%02d" , horaA , minA);

        return horaAc;
    }

}
