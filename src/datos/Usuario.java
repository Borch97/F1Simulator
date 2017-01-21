 package datos;

public class Usuario extends Coche {

	protected int dinero;
	
	public Usuario(int dinero) {
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
