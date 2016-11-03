package logica;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import datos.Rango;
import datos.Gestion;

public class Simulacion {

    //TODO
    //simulacion = tiempo aleatorio rango circuito - (media (Velocidad, aceleracion, aerodinamica))
	//metodo probRotura
	//metodo actualizacion despues de granpremio
	//prueba y creacion circuito
	
	
	
	
	
    public final int totalCoches = 10;



    public int aleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }

    public int tiempoVueltaAleatorio(int rangoInicial, int rangoFinal){
        return aleatorio(rangoInicial, rangoFinal);

    }

    //Obtiene un tiempo por vuelta aleatorio teniendo en cuenta una sere de parametros individuales de cada coche

    public Rango tiempoVueltaInicial(int rangoInicial, int rangoFinal, double velocidad, double aceleracion, double aerodinamica){
        //Gestion g = new Gestion();
        //int rango1 = (int)g.arrayCircuito.get(0).getRangoTiempo()[0];
        //int rango2 = (int)g.arrayCircuito.get(0).getRangoTiempo()[1];



       return milisegundosConversion((long)(tiempoVueltaAleatorio(rangoInicial, rangoFinal) -((velocidad*500 + aceleracion*500 + aerodinamica*500) / 3)));
    }

    //82648 milisegundos 1:22:826
    //Convierte en horas, minutos y segundos los milisegundos introducidos
    public Rango milisegundosConversion(long milisegundos){

        int milliseconds = (int) (milisegundos / 100);
        int seconds = (int) (milisegundos / 1000) % 60 ;
        int minutes = (int) ((milisegundos / (1000*60)) % 60);
        int hours   = (int) ((milisegundos / (1000*60*60)) % 24);

        System.out.println(hours + " Horas " + minutes + " Minutos " + seconds + " Segundos " + milliseconds + " Milisegundos");

        return new Rango(minutes, seconds, milliseconds);
    }


    public static void main(String[] args){
        Simulacion s = new Simulacion();
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 0, 0, 0));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 5, 1, 8));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 5, 5, 5));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 10, 10, 10));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 9, 10, 10));
    }
}
