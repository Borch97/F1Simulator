 package datos;

 import java.awt.*;

 public class Usuario extends Coche {

	protected int dinero;

	 public Usuario(String nom_piloto, int dinero) {
		 super(nom_piloto);
		 this.dinero = dinero;
		 this.nom_piloto = nom_piloto;
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
