package logica;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import datos.Circuito;
import datos.Rango;
import datos.Gestion;

public class Simulacion {

    //TODO
    //simulacion = tiempo aleatorio rango circuito - (media (Velocidad, aceleracion, aerodinamica))

    public final int totalCoches = 10;


    /** Metodo que dado un rango de valores, te devuelve un numero aleatorio entre dichos valores
     * @param min Valor entero minimo desde el cual deseas crear un numero aleatorio
     * @param max Valor entero maximo hasta el cual deseas crear un numero aleatorio
     * @return Devuelve un valor entero aleatorio dentro del rango establecido con los parametros de entrada
     */
    public int aleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }

    /**
     * Metodo que dado un rango inicial y un rango final, te devuelve un rango aleatorio entre dichos valores
     * @param rangoInicial
     * @param rangoFinal
     * @return Devuelve un rango aleatorio dentro de los valores establecidos
     */
    public int tiempoVueltaAleatorio(int rangoInicial, int rangoFinal){
        return aleatorio(rangoInicial, rangoFinal);

    }

    //Obtiene un tiempo por vuelta aleatorio teniendo en cuenta una sere de parametros individuales de cada coche

    /**
     * Metodo que dados una serie de valores, devuelve el tiempo de vuelta de un piloto en concreto
     * @param rangoInicial
     * @param rangoFinal
     * @param velocidad
     * @param aceleracion
     * @param aerodinamica
     * @return Devuelve el tiempo de vuelta de un piloto en concreto
     */
    public Rango tiempoVueltaInicial(int rangoInicial, int rangoFinal, double velocidad, double aceleracion, double aerodinamica){
       return milisegundosConversion((long)(tiempoVueltaAleatorio(rangoInicial, rangoFinal) -((velocidad*500 + aceleracion*500 + aerodinamica*500) / 3)));
    }

    //82648 milisegundos 1:22:826
    //Convierte en horas, minutos y segundos los milisegundos introducidos

    /**
     * Metodo que transforma los milisegundos en minutos, segundos y milisegundos
     * @param milisegundos
     * @return Devuelve la transformacion de los milisegundos a minutos, segundos y milisegundos
     */
    public Rango milisegundosConversion(long milisegundos){

        int milliseconds = (int) (milisegundos / 100);
        int seconds = (int) (milisegundos / 1000) % 60 ;
        int minutes = (int) ((milisegundos / (1000*60)) % 60);
        //int hours   = (int) ((milisegundos / (1000*60*60)) % 24);

        //System.out.println(minutes + " Minutos " + seconds + " Segundos " + milliseconds + " Milisegundos");

        return new Rango(minutes, seconds, milliseconds);
    }


    public static void main(String[] args){
        Simulacion s = new Simulacion();
        Gestion g = new Gestion();
        g.creacionAI();
        File f = new File("./pictures/Melbourne.png");
        Circuito barcelona = new Circuito("Barcelona", "Espanya", 50, 50.0,f, 82648, 85648);
        int cont = 0;
        Rango r;
        while (cont<g.totalPilotos) {
            r = s.tiempoVueltaInicial((int)barcelona.getRangoTiempoInicial(), (int)barcelona.getRangoTiempoFinal(),
                  g.arrayCoche.get(cont).getVelocidad(), g.arrayCoche.get(cont).getAceleracion(),g.arrayCoche.get(cont).getAerodinamica() );
            System.out.println(g.arrayCoche.get(cont).getNombre() + " = " + r.getMinutes() + ":" + r.getSeconds() + "," + r.getMilliseconds());
            cont++;
        }
        File p = barcelona.getFotoCircuito();
        System.out.println(p.getAbsolutePath());
        System.out.println(p.getAbsoluteFile());
       /* System.out.println(s.tiempoVueltaInicial(82648, 85648, 0, 0, 0));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 5, 1, 8));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 5, 5, 5));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 10, 10, 10));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 9, 10, 10));*/
    }
}
