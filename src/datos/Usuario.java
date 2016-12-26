 package datos;

public class Usuario {
	
	protected String nom_usuario;
	protected int dinero;
	
	public Usuario(String nom_usuario, int dinero) {
		this.nom_usuario = nom_usuario;
		this.dinero = dinero;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
	
	

}
