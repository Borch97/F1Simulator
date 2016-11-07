package datos;



public class Coche {

    protected String nombre;
    protected String abreviado;
    protected String escuderia;
    protected double velocidad;
    protected double aceleracion;
    protected double aerodinamica;
    protected double probRotura;

    /**
     * Contructor vacio con valores predeterminados
     */
    public Coche(){
        velocidad = 0;
        aceleracion = 0;
        aerodinamica = 0;
        probRotura = 0;
    }

    /**
     * Contructor para la creacion personalizada de un piloto
     * @param nombre
     * @param abreviado
     * @param escuderia
     * @param velocidad
     * @param aceleracion
     * @param aerodinamica
     * @param probRotura
     */
    public Coche(String nombre, String abreviado, String escuderia, double velocidad, double aceleracion, double aerodinamica, double probRotura) {
        this.nombre = nombre;
        this.abreviado = abreviado;
        this.escuderia = escuderia;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.aerodinamica = aerodinamica;
        this.probRotura = probRotura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviado() { return abreviado; }

    public void setAbreviado(String abreviado) { this.abreviado = abreviado; }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAerodinamica() {
        return aerodinamica;
    }

    public void setAerodinamica(double aerodinamica) {
        this.aerodinamica = aerodinamica;
    }

    public double getProbRotura() {
        return probRotura;
    }

    public void setProbRotura(double probRotura) {
        this.probRotura = probRotura;
    }
}
