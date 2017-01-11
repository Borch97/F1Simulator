package datos;




public class Coche {

	  protected String nom_piloto;
	    protected String abreviado;
	    protected String escuderia;
	    protected double velocidad;
	    protected double aceleracion;
	    protected double aerodinamica;
	    protected double prob_rotura;
	    protected double neumaticos;

	    //
	    protected int tiempo;
	    
	    
	    //en milisegundos
	    public int getTiempo()
	    {
	    	return tiempo;
	    }
	    
	    public void incrementarTiempo( int mins , int segs , int msegs )
	    {
	    	tiempo += msegs + segs*1000 + mins*60*1000;
	    }
	    
	    /**
	     * Contructor vacio con valores predeterminados
	     */
	    public Coche(){
	        velocidad = 0;
	        aceleracion = 0;
	        aerodinamica = 0;
	        prob_rotura = 0;
	        //
	        tiempo = 0;
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
	    public Coche(String nombre, String abreviado, String escuderia, double velocidad, double aceleracion, double aerodinamica, double probRotura, double neumaticos) {
	        this.nom_piloto = nombre;
	        this.abreviado = abreviado;
	        this.escuderia = escuderia;
	        this.velocidad = velocidad;
	        this.aceleracion = aceleracion;
	        this.aerodinamica = aerodinamica;
	        this.prob_rotura = probRotura;
	        this.neumaticos = neumaticos;
	    }

	    public String getNombre() {
	        return nom_piloto;
	    }

	    public void setNombre(String nombre) {
	        this.nom_piloto = nombre;
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
	        return prob_rotura;
	    }

	    public void setProbRotura(double probRotura) {
	        this.prob_rotura = probRotura;
	    }

	    public double getNeumaticos() { return neumaticos;
	    }

	    public void setNeumaticos(double neumaticos) { this.neumaticos = neumaticos;
	    }
	}
