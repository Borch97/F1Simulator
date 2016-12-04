package cambiar;

import java.util.ArrayList;
import java.util.Random;

import BD.GestorBD;
import datos.Coche;

public class Gestion {
	
    public final int totalPilotos = 9;
	    
    public ArrayList<String> arrayNombres;
    public ArrayList<String> arrayEscuderias;
    public ArrayList<Coche> arrayCoche = new ArrayList<>();
    
    public Gestion()
    {
    	arrayNombres = GestorBD.getInstance().obtenerInfoPilotos();
    	arrayEscuderias = GestorBD.getInstance().obtenerInfoEscuderias();
    }
        
    private int aleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }
    
	public Coche creacionPiloto() {

		String nombrepiloto = arrayNombres.get(aleatorio(0, arrayNombres.size() - 1));
		String nombreescuderia = arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1));

		return new Coche(nombrepiloto, " ", nombreescuderia, aleatorio(0, 10), aleatorio(0, 10), aleatorio(0, 10), 0,
				100);

	}

	public void creacionAI() {

		Coche cocheComprobar;
		for (int j = totalPilotos; j > 0; j--) {
			cocheComprobar = creacionPiloto();
			while ((containsElement(arrayCoche, cocheComprobar.getNombre()))
					|| contains2Elements(arrayCoche, cocheComprobar.getEscuderia())) {
				cocheComprobar = creacionPiloto();
			}
			cocheComprobar.setAbreviado(cocheComprobar.getNombre().substring(0, 4));
			arrayCoche.add(cocheComprobar);
		}
	}

	/**
	 * Metodo que comprueba que no haya mas de un piloto con el mismo nombre
	 * 
	 * @param arrayCoche
	 * @param nombre
	 * @return
	 */
	public boolean containsElement(ArrayList<Coche> arrayCoche, String nombre) {
		int cont = 0;
		boolean contains = false;
		for (Coche coche : arrayCoche) {
			if (coche.getNombre().equals(nombre)) {
				cont++;
			}
		}
		if (cont >= 1)
			contains = true;
		return contains;
	}

	// Metodo que comprueba si existen 2 o mas elementos especificos en un array

	/**
	 * Metodo que comprueba que no haya mas de dos pilotos en una misma
	 * escuderia
	 * 
	 * @param arrayCoche
	 * @param escuderia
	 * @return
	 */
	public boolean contains2Elements(ArrayList<Coche> arrayCoche, String escuderia) {
		int cont = 0;
		boolean contains2total = false;
		for (Coche coche : arrayCoche) {
			if (coche.getEscuderia().equals(escuderia)) {
				cont++;
			}
		}
		if (cont == 2)
			contains2total = true;
		return contains2total;
	}
}
