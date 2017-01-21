package datos;

// https://github.com/Borch97/F1Simulator.git
import java.awt.*;
import java.io.File;
import java.lang.Object;
import java.time.Duration;

public class Circuito {

	 protected String nom_circuito;
	    protected String pais;
	    protected int num_vueltas;
	    protected double pro_lluvia;
	    protected String foto_circ;
	    protected  int rango_tinicial;
	    protected int rango_tfinal;
		protected int posicionCircuito;


	    /**
	     * Contructor vacio con valores predeterminados
	     */
	    public Circuito(){
	        nom_circuito = " ";
	        pais = " ";
	        pro_lluvia = 0;
	    }

	    /**
	     * Contructor para la creacion personalizada de un circuito
	     * @param nombre
	     * @param pais
	     * @param vueltas
	     * @param probLluvia
	     * @param fotoCircuito
	     * @param rangoTiempoInicial
	     * @param rangoTiempoFinal
	     */
	    public Circuito(String nombre, String pais, int vueltas, double probLluvia, String fotoCircuito, int rangoTiempoInicial, int rangoTiempoFinal, int posicionCircuito) {
	        this.nom_circuito = nombre;
	        this.pais = pais;
	        this.num_vueltas = vueltas;
	        this.pro_lluvia = probLluvia;
	        this.foto_circ = fotoCircuito;
	        this.rango_tinicial = rangoTiempoInicial;
	        this.rango_tfinal = rangoTiempoFinal;
			this.posicionCircuito = posicionCircuito;
	    }

		public String getNom_circuito() {return nom_circuito;}

		public void setNom_circuito(String nom_circuito) {this.nom_circuito = nom_circuito;}

		public int getNum_vueltas() {return num_vueltas;}

		public void setNum_vueltas(int num_vueltas) {this.num_vueltas = num_vueltas;}

		public double getPro_lluvia() {return pro_lluvia;}

		public void setPro_lluvia(double pro_lluvia) {this.pro_lluvia = pro_lluvia;}

		public String getFoto_circ() {return foto_circ;}

		public void setFoto_circ(String foto_circ) {this.foto_circ = foto_circ;}

		public int getRango_tinicial() {return rango_tinicial;}

		public void setRango_tinicial(int rango_tinicial) {this.rango_tinicial = rango_tinicial;}

		public int getRango_tfinal() {return rango_tfinal;}

		public void setRango_tfinal(int rango_tfinal) {this.rango_tfinal = rango_tfinal;}

		public int getPosicionCircuito() {return posicionCircuito;}

		public void setPosicionCircuito(int posicionCircuito) {this.posicionCircuito = posicionCircuito;}

		public String getNombre() {
				return nom_circuito;
			}

	    public void setNombre(String nombre) {
	        this.nom_circuito = nombre;
	    }

	    public String getPais() {
	        return pais;
	    }

	    public void setPais(String pais) {
	        this.pais = pais;
	    }

	    public int getVueltas() {
	        return num_vueltas;
	    }

	    public void setVueltas(int vueltas) {
	        this.num_vueltas = vueltas;
	    }

	    public double getProbLluvia() {
	        return pro_lluvia;
	    }

	    public void setProbLluvia(double probLluvia) {
	        this.pro_lluvia = probLluvia;
	    }

	    public String getFotoCircuito() {
	        return foto_circ;
	    }

	    public void setFotoCircuito(String fotoCircuito) { this.foto_circ = fotoCircuito;
	    }

	    public long getRangoTiempoInicial() {  return rango_tinicial;
	    }

	    public void setRangoTiempoInicial(int rangoTiempoInicial) {  this.rango_tinicial = rangoTiempoInicial;
	    }

	    public long getRangoTiempoFinal() {    return rango_tfinal;
	    }

	    public void setRangoTiempoFinal(int rangoTiempoFinal) {  this.rango_tfinal = rangoTiempoFinal;
	    }

	    public static void main(String[] args){
	        Circuito c = new Circuito();
	        /*c.rangoTiempo[0] = c.rangoTiempo[0].ofSeconds(3600);
	        System.out.println(c.rangoTiempo[0].toHours());
	        System.out.println(c.rangoTiempo[0].toMinutes());*/

	    }

	}
