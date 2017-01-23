 package datos;

 import java.awt.*;

 public class Usuario extends Coche {

     protected int dinero;
     protected int contCircuito = 0;

	 public Usuario(String nom_piloto, int dinero, String nom_usuario, int contCircuito) {
		 super(nom_piloto);
		 this.dinero = dinero;
		 this.nom_piloto = nom_piloto;
		 this.nom_usuario = nom_usuario;
         this.contCircuito = contCircuito;
	 }

     public Usuario(String nom_piloto, String abreviado, String escuderia, double velocidad, double aceleracion, double aerodinamica, double prob_rotura, double neumaticos, Image imagen, int paradasBoxes, String nom_usuario, int puntos, int dinero, int contCircuito, Rango tiempo) {
         super(nom_piloto, abreviado, escuderia, velocidad, aceleracion, aerodinamica, prob_rotura, neumaticos, imagen, paradasBoxes, nom_usuario, puntos);
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
         this.nom_usuario = nom_usuario;
         this.puntos = puntos;
         this.dinero = dinero;
         this.contCircuito = contCircuito;
         this.tiempo = tiempo;
     }

     public Usuario(){}

	 public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

     public int getContCircuito() {return contCircuito;}

     public void setContCircuito(int contCircuito) {this.contCircuito = contCircuito;}

     public static void main(String[] args){
        Usuario u = new Usuario();
    }
	
	
	

}
