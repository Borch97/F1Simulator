package datos;


import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Gestion {

    protected final int totalPilotos = 9;
    protected ArrayList<Coche> arrayCoche = new ArrayList<>();
    public ArrayList<Circuito> arrayCircuito = new ArrayList<>();
    public ArrayList<String> arrayNombres = new ArrayList<>(Arrays.asList("Hamilton", "Vettel", "Verstappen", "Alonso", "Button", "Sainz", "Massa", "Rosberg", "Ricciardo", "Perez", "Bottas"));
    public ArrayList<String> arrayEscuderias = new ArrayList<>(Arrays.asList("Mercedes", "Ferrari", "Williams", "Mclaren Honda", "Red Bull", "Renault", "Haas", "Toro Rosso"));


    //Crea un entero aleatorio dentro de los limites establecidos
    public int aleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }

    //Crea un piloto nuevo completamente aleatorio
    public Coche creacionPiloto(){
        return new Coche(arrayNombres.get(aleatorio(0, arrayNombres.size() - 1)), arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1)), aleatorio(0, 10), aleatorio(0, 10), aleatorio(0, 10), 0);
    }
    //Método que se encarga de crear automaticamente todos los otros pilotos del modo carrera
    public void creacionAI(){
        int contPilotos = totalPilotos;
         // while(arrayCoche.isEmpty() || arrayCoche.size()<totalPilotos) {
              Coche cocheComprobar = new Coche();
              for (int j = contPilotos; j > 0; j--) {
                  cocheComprobar = creacionPiloto();
                  while((containsElement(arrayCoche, cocheComprobar.getNombre())) || contains2Elements(arrayCoche, cocheComprobar.getEscuderia())){
                      cocheComprobar = creacionPiloto();
                  }
                  arrayCoche.add(cocheComprobar);
              }

          //}
    }
    //Metodo que comprueba si existe otro elemento dentro del array con el mismo nombre
    public boolean containsElement(ArrayList<Coche> arrayCoche, String nombre){
        int cont = 0;
        boolean contains = false;
        for (Coche coche: arrayCoche) {
            if(coche.getNombre().equals(nombre)){
                cont++;
            }
        }
        if(cont >= 1)
            contains = true;
        return contains;
    }

    //Método que comprueba si existen 2 o más elementos específicos en un array
    public boolean contains2Elements(ArrayList<Coche> arrayCoche, String escuderia){
        int cont = 0;
        boolean contains2total = false;
        for (Coche coche: arrayCoche) {
            if(coche.getEscuderia().equals(escuderia)){
                cont++;
            }
        }
        if(cont == 2)
            contains2total = true;
        return contains2total;
    }


    public static void main(String[] args){
        Gestion g = new Gestion();
        Duration[]duration = new Duration[2];
        duration[0] = duration[0].ofMillis(82648);
        duration[1] = duration[0].ofMillis(85648);
        File path = new File("E:\\Programacion\\IJ\\F1Simulator\\src\\pictures\\Melbourne.png");

         // Circuito m = new Circuito("Melbourne", "Australia", 30, 3000.5, 0.0, path , duration);
        //g.arrayCircuito.add(m);
        g.creacionAI();
        for (Coche coche: g.arrayCoche) {
            System.out.println("Nombre: " + coche.getNombre() + " Escuderia: "+ coche.getEscuderia() + " Velocidad : " + coche.getVelocidad() + " Aceleracion : " + coche.getAceleracion() + " Aerodinamica: " + coche.getAerodinamica() + " Probabilidad Rotura: " + coche.getProbRotura());
        }
    }
}
