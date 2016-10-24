package datos;


import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class Gestion {

    protected final int totalPilotos = 9;
    protected ArrayList<Coche> arrayCoche = new ArrayList<>();
    public ArrayList<Circuito> arrayCircuito = new ArrayList<>();



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


    public static void main(String[] args){
        Gestion g = new Gestion();
        Duration[]duration = new Duration[2];
        duration[0] = duration[0].ofMillis(82648);
        duration[1] = duration[0].ofMillis(85648);
        File path = new File("E:\\Programacion\\IJ\\F1Simulator\\src\\pictures\\Melbourne.png");

        Circuito m = new Circuito("Melbourne", "Australia", 30, 3000.5, 0.0, path , duration);
        g.arrayCircuito.add(m);
    }
}
