package logica;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import GUI.Ventana;
import datos.Circuito;
import datos.Coche;
import datos.Rango;
import datos.Gestion;

public class Simulacion{

    //TODO
    //simulacion = tiempo aleatorio rango circuito - (media (Velocidad, aceleracion, aerodinamica))
	//metodo probRotura
	//metodo actualizacion despues de granpremio
	//prueba y creacion circuito
	
	
	
	
	
    public final int totalCoches = 10;
    Gestion g = new Gestion();


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

    public void simulacionVueltas(ArrayList<Circuito> circuito, int pos, ArrayList<Coche> piloto, ArrayList<String> tiempoVuelta, ArrayList<Rango> tiempos, ArrayList<String> posPilotos){
        int cont = 0;
        Rango r;
        while (cont<g.totalPilotos) {
            r = this.tiempoVueltaInicial((int)circuito.get(pos).getRangoTiempoInicial(), (int)circuito.get(pos).getRangoTiempoFinal(),
                    piloto.get(cont).getVelocidad(), piloto.get(cont).getAceleracion(),piloto.get(cont).getAerodinamica() );
            tiempoVuelta.add((cont + 1) + ".-" + piloto.get(cont).getNombre().substring(0,4) + " = " + r.getMinutes() + ":" + r.getSeconds() + "," + r.getMilliseconds());
            tiempos.add(r);
            posPilotos.add(piloto.get(cont).getAbreviado());
            cont++;
        }
    }

    public void calcularDiferencia(ArrayList<Rango> tiempo1, ArrayList<Rango> tiempo2, ArrayList<String> diferenciaTiempo){
        for(int i = 0;i < tiempo1.size();i++){
            for(int j = i+1;j < tiempo2.size();j++){
                int minutes = tiempo2.get(j).getMinutes() - tiempo1.get(i).getMinutes();
                int seconds = tiempo2.get(j).getSeconds() - tiempo1.get(i).getSeconds();
                int miliseconds = tiempo2.get(j).getMilliseconds() - tiempo1.get(i).getMilliseconds();
                Rango r = new Rango(minutes,seconds,miliseconds);
                if(r.getMinutes() < 0 || r.getSeconds() < 0 || r.getMilliseconds() < 0){
                    tiempo2.add(tiempo2.get(i));
                    tiempo2.set(j,tiempo2.get(i));
                    tiempo2.set(i,tiempo2.get(tiempo2.size()-1));
                    tiempo2.remove(tiempo2.size()-1);
                }
                if (minutes == 0){
                    if(seconds > 0){
                        if(miliseconds > 0){
                            diferenciaTiempo.add(j + "+" + r.getSeconds() + "," + r.getMilliseconds());
                        }
                        else diferenciaTiempo.add(j + "+" + r.getSeconds() + "," + r.getMilliseconds());
                    }
                    else{
                        if(miliseconds > 0){
                         diferenciaTiempo.add(j + "+" + r.getSeconds() + "," + r.getMilliseconds());
                     }
                        else diferenciaTiempo.add(j + r.getSeconds() + "," + r.getMilliseconds());
                }
                }
            }
        }
    }
    //TODO
    //Temporal
    public Circuito crearCircuito(){
       return  new Circuito("Barcelona", "Espanya", 50, 50.0,"./pictures/Melbourne.png", 82648, 85648);
    }


    public void gestionNeumaticos(ArrayList<Coche> coches){
        for(int i = 0; i < coches.size();i++){
            coches.get(i).setNeumaticos(coches.get(i).getNeumaticos() - 5);
        }
    }
    
    public boolean lluvia (ArrayList<Circuito> prob_lluvia){
    	boolean llueve = false;
    	int numeroAleatorio = (int) (Math.random()*100+1);
    	if((prob_lluvia.get(0).getProbLluvia) > numeroAleatorio){
    		llueve = true;
    	}else{
    		llueve = false;
    	}
    	
    	
    	return llueve;
    }


    public static void main(String[] args){
        Simulacion s = new Simulacion();
        Gestion g = new Gestion();
        g.creacionAI();
        
        Circuito barcelona = new Circuito("Barcelona", "Espanya", 50, 50.0,"./pictures/Melbourne.png", 82648, 85648);
        
        Circuito barcelona = GestorBD.obtenerInfoCircuito("Barcelona");
        
        int cont = 0;
        Rango r;
        while (cont<g.totalPilotos) {
            r = s.tiempoVueltaInicial((int)barcelona.getRangoTiempoInicial(), (int)barcelona.getRangoTiempoFinal(),
                  g.arrayCoche.get(cont).getVelocidad(), g.arrayCoche.get(cont).getAceleracion(),g.arrayCoche.get(cont).getAerodinamica() );
            g.arrayTiempoVuelta.add(g.arrayCoche.get(cont).getNombre() + " = " + r.getMinutes() + ":" + r.getSeconds() + "," + r.getMilliseconds());
            cont++;
        }
        for (Coche coche: g.arrayCoche) {
            System.out.println("Nombre: " + coche.getNombre() + " Neumaticos: "+ coche.getNeumaticos());
        }
        s.gestionNeumaticos(g.arrayCoche);
        System.out.println("===============================================================");
        for (Coche coche: g.arrayCoche) {
            System.out.println("Nombre: " + coche.getNombre() + " Neumaticos: "+ coche.getNeumaticos());
        }
        //File p = barcelona.getFotoCircuito();
        //System.out.println(p.getAbsolutePath());
        //System.out.println(p.getAbsoluteFile());
       /* System.out.println(s.tiempoVueltaInicial(82648, 85648, 0, 0, 0));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 5, 1, 8));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 5, 5, 5));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 10, 10, 10));
        System.out.println(s.tiempoVueltaInicial(82648, 85648, 9, 10, 10));*/
    }


}
