package corrector;

import java.util.ArrayList;
import java.util.List;

public class Datos {
                                                // Configuración
    private static String usuarioActual;
    private static boolean esAdmin;
    private static String fichaActiva;
    private static String administrador;
    private static String contrasena;
    private static String archivoPortada;
    private static String archivoError;
    private static String idioma;
    private static String informe;
    private static String fichaArranque;
    private static String carpetaFichas;
    private static String alSolucionarFicha;
    private static boolean inicioAnonimo;
                                                // Datos Ficha
    private static String nombreFch;
    private static String archivoInicialFch;
    private static String carpetaFch;
    private static String archivoAyudaFch;
    private static String numeroPreguntasFch;
    private static boolean esDeConsultaFch;
    private static boolean esNuevaFch;
    private static String nivelFch;
    private static String cursoFch;
    private static String areaFch;
    private static String temaFch;
    //private static String comandosFch;
    //private static String tipoFch;
                                                //Comandos Tipo y Respuesta de las preguntas
    static List<String> comandosPreg = new ArrayList<>();
    static List<String> tipoPreg = new ArrayList<>();
    static List<String> respPregunta = new ArrayList<>();
    static List<String> respUsuario = new ArrayList<>();
                                                // ==========================================
    private static String comandosInicioFch;
    private static boolean activarCalcFch;
    private static boolean activarBlocFch;
    private static boolean activarAyudaCrrFch;
    private static boolean activarCronoFch;
    private static String tipoCorreccionFch;
    private static String envioEmailFch;
    private static String envioInformeFch;



    public void setUsuarioActual(String usuario){ usuarioActual = usuario;}
    public void setEsAdmin(boolean esAd) { esAdmin = esAd;}
    public void setFichaActiva(String fch) { fichaActiva = fch;}
    public void setAdministrador(String ad) { administrador = ad;}
    public void setContrasena(String pass) { contrasena = pass;}
    public void setArchivoPortada(String port) { archivoPortada = port;}
    public void setArchivoError(String err) { archivoError = err;}
    public void setIdioma(String id) { idioma = id;}
    public void setInforme(String inf) { informe = inf;}
    public void setFichaArranque(String arr) { fichaArranque = arr;}
    public void setCarpetaFichas(String carp) { carpetaFichas = carp;}
    public void setAlSolucionarFicha(String alSolucFch) { alSolucionarFicha = alSolucFch;}
    public void setInicioAnonimo(boolean iniAnonim) { inicioAnonimo = iniAnonim;}

    public void setNombreFch(String nomF) { nombreFch = nomF;}
    /*public void setArchivoInicioFch(String archIniF) { archivoInicialFch = archIniF;
        // Encontrar el índice de la última ocurrencia de "/"
        int lastIndex = archIniF.lastIndexOf("/");
        // Extraer la parte izquierda del string
        carpetaFch = archIniF.substring(0, lastIndex);}
     */
    public void setArchivoInicioFch(String archIniF) {
        archivoInicialFch = archIniF;
        if (archIniF == null || archIniF.isEmpty()) { carpetaFch = ""; return;}
        int lastIndex = archIniF.lastIndexOf("/");
        if (lastIndex >= 0) { carpetaFch = archIniF.substring(0, lastIndex);}
            else { carpetaFch = "";}
    }
    public void setArchivoAyudaFch(String archAyuF) { archivoAyudaFch = archAyuF;}
    public void setNumeroPreguntasFch(String nPrF) { numeroPreguntasFch = nPrF;}
    public void setEsDeConsultaFch(boolean consF) { esDeConsultaFch = consF;}
    public void setEsNuevaFch(boolean nuevaF) { esNuevaFch = nuevaF;}
    public void setNivelFch(String nivF) { nivelFch = nivF;}
    public void setCursoFch(String cursF) { cursoFch = cursF;}
    public void setAreaFch(String arF) { areaFch = arF;}
    public void setTemaFch(String temF) { temaFch = temF;}
    public void setComandosPreg(int nPreg, String comF) { comandosPreg.set(nPreg, comF);}
    public void setTipoPreg(int nPreg, String tipoF) {tipoPreg.set(nPreg, tipoF);}
    public void setRespPregunta(int nPreg, String respF) {respPregunta.set(nPreg, respF);}
    public void setComandosInicioFch(String cIniF) { comandosInicioFch = cIniF;}
    public void setActivarCalcFch(boolean calF) { activarCalcFch = calF;}
    public void setActivarBlocFch(boolean blocF) { activarBlocFch = blocF;}
    public void setActivarAyudaCrrFch(boolean ayCrrF) { activarAyudaCrrFch = ayCrrF;}
    public void setActivarCronoFch(boolean cronoF) { activarCronoFch = cronoF;}
    public void setTipoCorreccionFch(String tipF) { tipoCorreccionFch = tipF;}
    public void setEnvioEmailFch(String emailF) { envioEmailFch = emailF;}
    public void setEnvioInformeFch(String infF) { envioInformeFch = infF;}

    public String getUsuarioActual() { return usuarioActual;}
    public boolean getEsAdmin() { return esAdmin;}
    public String getFichaActiva() { return fichaActiva;}
    public String getAdministrador() { return administrador;}
    public String getContrasena() { return contrasena;}
    public String getArchivoPortada() { return archivoPortada;}
    public String getArchivoError() {return archivoError;}
    public String getIdioma() { return idioma;}
    public String getInforme() { return informe;}
    public String getFichaArranque() { return fichaArranque;}
    public String getCarpetaFichas() { return carpetaFichas;}
    public String getAlSolucionarFicha() { return alSolucionarFicha;}
    public boolean getInicioAnonimo() { return inicioAnonimo;}

    public String getNombreFch() { return nombreFch;}
    public String getArchivoInicialFch() { return archivoInicialFch;}
    public String getCarpetaFch() { return carpetaFch;}
    public String getArchivoAyudaFch() { return archivoAyudaFch;}
    public String getNumeroPreguntasFch() { return numeroPreguntasFch;}
    public boolean getEsDeConsultaFch() { return esDeConsultaFch;}
    public boolean getEsNuevaFch() { return esNuevaFch;}
    public String getNivelFch() { return nivelFch;}
    public String getCursoFch() { return cursoFch;}
    public String getAreaFch() { return areaFch;}
    public String getTemaFch() { return temaFch;}
    public String getComandosPreg(int nPreg) { return comandosPreg.get(nPreg);}
    public String getTipoPreg(int nPreg) { return tipoPreg.get(nPreg);}
    public String getRespPregunta(int nPreg) { return respPregunta.get(nPreg);}
    public String getComandosInicioFch() { return comandosInicioFch;}
    public boolean getActivarCalcFch() { return activarCalcFch;}
    public boolean getActivarBlocFch() { return activarBlocFch;}
    public boolean getActivarAyudaCrrFch() { return activarAyudaCrrFch;}
    public boolean getActivarCronoFch() { return activarCronoFch;}
    public String getTipoCorreccionFch() { return tipoCorreccionFch;}
    public String getEnvioEmailFch() { return envioEmailFch;}
    public String getEnvioInformeFch() { return envioInformeFch;}

    public void inicializarFch() {
        nombreFch = "";
        archivoInicialFch = "";
        archivoAyudaFch = "";
        numeroPreguntasFch = "0";
        esDeConsultaFch = false;
        esNuevaFch = false;
        nivelFch = "...";
        cursoFch = "...";
        areaFch = "...";
        temaFch = "";
        comandosInicioFch = "";
        activarCalcFch = false;
        activarBlocFch = false;
        activarAyudaCrrFch = false;
        activarCronoFch = false;
        tipoCorreccionFch = "";
        envioEmailFch = "";
        envioInformeFch = "";
        inicializarComTipResp(0);
    }

    public void inicializarComTipResp( int nPrg) {
        comandosPreg.clear();
        tipoPreg.clear();
        respPregunta.clear();
        respUsuario.clear();

        for  ( int i=0; i<=nPrg; i++ ) {
            comandosPreg.add( i, "");
            tipoPreg.add( i, "");
            respPregunta.add( i , "");
            respUsuario.add( i, "");
        }

    }

}
