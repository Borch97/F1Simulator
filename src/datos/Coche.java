package datos;


import logica.Simulacion;

import java.awt.*;


public class Coche {

	  protected String nom_piloto;
	    protected String abreviado;
	    protected String escuderia;
	    protected double velocidad;
	    protected double aceleracion;
	    protected double aerodinamica;
	    protected double prob_rotura;
	    protected double neumaticos;
		protected Image imagen;
		protected int paradasBoxes;
	//	protected String nom_usuario;

	    //
	    protected Rango tiempo;

		Simulacion s = new Simulacion();
	    
	    
	    //en milisegundos
	    public Rango getTiempo()
	    {
	    	return tiempo;
	    }

    public void setTiempo(Rango tiempo) {
        this.tiempo = tiempo;
    }

    public void incrementarTiempo(int mins , int segs , int msegs )
	    {
			if(tiempo != null) {
				long t1 = s.rangoMilisegundos(tiempo.getMinutes(), tiempo.getSeconds(), tiempo.getMilliseconds());
				long t2 = msegs + segs * 1000 + mins * 60 * 1000;
				tiempo = s.milisegundosConversion(t1 + t2);
			}
	    }
	    
	    /**
	     * Contructor vacio con valores predeterminados
	     */
	    public Coche(){
	    	
	        velocidad = 0;
	        aceleracion = 0;
	        aerodinamica = 0;
	        prob_rotura = 0;

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
	    
	    public Coche(String nom_piloto, String abreviado, String escuderia,
				double velocidad, double aceleracion, double aerodinamica, double prob_rotura, double neumaticos,
				Image imagen, int paradasBoxes) {
			this.nom_piloto = nom_piloto;
			this.abreviado = abreviado;
			this.escuderia = escuderia;
			this.velocidad = velocidad;
			this.aceleracion = aceleracion;
			this.aerodinamica = aerodinamica;
			this.prob_rotura = prob_rotura;
			this.neumaticos = neumaticos;
			this.imagen = imagen;
			this.paradasBoxes = paradasBoxes;
			//this.nom_usuario= nom_usuario;
			this.tiempo = tiempo;
			this.s = s;
		}
	   

		public String getNom_piloto() {
			return nom_piloto;
		}

		

		public void setNom_piloto(String nom_piloto) {
			this.nom_piloto = nom_piloto;
		}

		public String getAbreviado() {
			return abreviado;
		}

		public void setAbreviado(String abreviado) {
			this.abreviado = abreviado;
		}

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

		public double getProb_rotura() {
			return prob_rotura;
		}

		public void setProb_rotura(double prob_rotura) {
			this.prob_rotura = prob_rotura;
		}

		public double getNeumaticos() {
			return neumaticos;
		}

		public void setNeumaticos(double neumaticos) {
			this.neumaticos = neumaticos;
		}

		public Image getImagen() {
			return imagen;
		}

		public void setImagen(Image imagen) {
			this.imagen = imagen;
		}

		public int getParadasBoxes() {
			return paradasBoxes;
		}

		public void setParadasBoxes(int paradasBoxes) {
			this.paradasBoxes = paradasBoxes;
		}

		public Simulacion getS() {
			return s;
		}

		public void setS(Simulacion s) {
			this.s = s;
		}

		/**public String getNom_usuario() {
			return nom_usuario;
		}

		public void setNom_usuario(String nom_usuario) {
			this.nom_usuario = nom_usuario;
		}*/

		
	}
