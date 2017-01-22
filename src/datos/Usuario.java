 package datos;

 import java.awt.*;

 public class Usuario extends Coche {

	protected int dinero;

	 public Usuario(String nom_piloto, int dinero) {
		 super(nom_piloto);
		 this.dinero = dinero;
		 this.nom_piloto = nom_piloto;
	 }

     public Usuario(String nom_piloto, String abreviado, String escuderia, double velocidad, double aceleracion, double aerodinamica, double prob_rotura, double neumaticos, Image imagen, int paradasBoxes, String nom_usuario, int puntos, int dinero) {
         super(nom_piloto, abreviado, escuderia, velocidad, aceleracion, aerodinamica, prob_rotura, neumaticos, imagen, paradasBoxes, nom_usuario, puntos);
         this.dinero = dinero;
     }

     public Usuario(){}

	 public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}


    public static void main(String[] args){
        Usuario u = new Usuario();
    }
	
	
	

}
