package corrector;

public class Datos {
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
    public boolean getInicioAnonimo() {return inicioAnonimo;}

}
