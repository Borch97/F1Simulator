package datos;


import java.util.ArrayList;
import java.util.Random;

public class Gestion {

    protected final int totalPilotos = 9;
    protected ArrayList<Coche> arrayCoche = new ArrayList<>();



    public int aleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }

    /*public Coche creacionPiloto(String nombre, String escuderia, double velocidad, double aceleracion, double aerodinamica, double probRotura){
        return Coche(nombre, escuderia, velocidad, aceleracion, aerodinamica, probRotura);
    }*/

    public void creacionAI(){
          while(arrayCoche.isEmpty() || arrayCoche.size()<totalPilotos);
                //TODO
                //arrayCoche.add(Coche());
    }
}
