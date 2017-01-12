package datos;


import java.io.File;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import BD.GestorBD;

public class Gestion {

    public final int totalPilotos = 9;
    public ArrayList<Coche> arrayCoche = new ArrayList<>();
    public ArrayList<Circuito> arrayCircuito = new ArrayList<>();
    public ArrayList<String> arrayNombres; //= new ArrayList<>(Arrays.asList("Hamilton", "Vettel", "Verstappen", "Alonso", "Button", "Sainz", "Massa", "Rosberg", "Ricciardo", "Perez", "Bottas"));
    public ArrayList<String> arrayEscuderias; // = new ArrayList<>(Arrays.asList("Mercedes", "Ferrari", "Williams", "Mclaren Honda", "Red Bull", "Renault", "Haas", "Toro Rosso"));
    public ArrayList<String> arrayTiempoVuelta = new ArrayList<>();
    public ArrayList<Rango> arrayTiempoVueltaSoloInicial = new ArrayList<>();
    public ArrayList<Rango> arrayTiempoVueltaSoloCopia = new ArrayList<>();
    public ArrayList<Rango> arrayDiferenciaTiempoVuelta = new ArrayList<>();
    public ArrayList<String> posPiloto = new ArrayList<>();
    public ArrayList<String> nombreColumnas = new ArrayList<>();
    public String[] columnNames = {"Posición", "Nombre", "Coche", "Tiempo", "Diferencia", "P. Boxes"};
    public ArrayList<informacionTabla> informacionTabla = new ArrayList<>();


    //Obtener nombre y escuderia de la base de datos
    
    public Gestion()
    {
    	arrayNombres = GestorBD.getInstance().obtenerInfoPilotos();
    	arrayEscuderias = GestorBD.getInstance().obtenerInfoEscuderias();
    }

    public int buscarPiloto(ArrayList<Coche> arrayCoche, String nombre){
        int pos = 0;
        int i = 0;
        for (Coche c : arrayCoche){
            if(c.getNombre() == nombre){
                pos = i;
                break;
            }
            else
                i++;
        }
        return pos;
    }
    /*public void recopilarInformacion(ArrayList<informacionTabla> arrayInformacionTabla){
        for(int i = 0; i<= totalPilotos;i++){
            informacionTabla a = new informacionTabla(arrayCoche.get(i).getNombre(),arrayCoche.get(i).getImagen(), arrayTiempoVuelta.get(buscarPiloto(arrayCoche,arrayCoche.get(i).getNombre())),arrayDiferenciaTiempoVuelta.get(buscarPiloto(arrayCoche,arrayCoche.get(i).getNombre())),arrayCoche.get(i).getParadasBoxes());
            arrayInformacionTabla.add(a);
        }
    }*/

    //Crea un entero aleatorio dentro de los limites establecidos

    /** Metodo que dado un rango de valores, te devuelve un numero aleatorio entre dichos valores
     * @param min Valor entero minimo desde el cual deseas crear un numero aleatorio
     * @param max Valor entero maximo hasta el cual deseas crear un numero aleatorio
     * @return Devuelve un valor entero aleatorio dentro del rango establecido con los parametros de entrada
     */
    public int aleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }

    //Crea un piloto nuevo completamente aleatorio

    /**
     * Crea un nuevo piloto de tipo Coche con todos los valores aleatorios, incluidos el nombre y la escuderia, basandose en un array de Strings
     * @return Devuelve un nuevo piloto de tipo Coche con todos los valores aleatorios
     */
    public Coche creacionPiloto(){
    	
    	String nombrepiloto = arrayNombres.get(aleatorio(0, arrayNombres.size() - 1));
		String nombreescuderia = arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1));
        //TODO añadir imagen coche
		return new Coche(nombrepiloto, " ", nombreescuderia, aleatorio(0, 10), aleatorio(0, 10), aleatorio(0, 10), 0,
				100, null, 0);
    	// return new Coche(arrayNombres.get(aleatorio(0, arrayNombres.size() - 1))," ", arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1)), aleatorio(0, 10), aleatorio(0, 10), aleatorio(0, 10), 0, 100);
    }
    //Metodo que se encarga de crear automaticamente todos los otros pilotos del modo carrera

    /**
     * Metodo que crea todos los coches de la AI del juego, comprobando que que no se repita el nombre y haya un maximo de dos pilotos por escuderia
     * Crea un numero de pilotos igual a la variable totalPilotos.
     */
    public void creacionAI(){
        // while(arrayCoche.isEmpty() || arrayCoche.size()<totalPilotos) {
              Coche cocheComprobar;
        if(arrayCoche.isEmpty()) {
            for (int j = totalPilotos; j > 0; j--) {
                cocheComprobar = creacionPiloto();
                while ((containsElement(arrayCoche, cocheComprobar.getNombre())) || contains2Elements(arrayCoche, cocheComprobar.getEscuderia())) {
                    cocheComprobar = creacionPiloto();
                }
                cocheComprobar.setAbreviado(cocheComprobar.getNombre().substring(0, 4));
                arrayCoche.add(cocheComprobar);
            }
        }
        else {
            arrayCoche.clear();
            creacionAI();
        }

          //}
    }
    //Metodo que comprueba si existe otro elemento dentro del array con el mismo nombre

    /**
     * Metodo que comprueba que no haya mas de un piloto con el mismo nombre
     * @param arrayCoche
     * @param nombre
     * @return
     */
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

    //Metodo que comprueba si existen 2 o mas elementos especificos en un array

    /**
     * Metodo que comprueba que no haya mas de dos pilotos en una misma escuderia
     * @param arrayCoche
     * @param escuderia
     * @return
     */
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

    public void copiarArray(ArrayList<Rango> arrayTiempoVueltaSoloInicial, ArrayList<Rango> arrayTiempoVueltaSoloCopia){
        for(int i = 0;i<arrayTiempoVueltaSoloInicial.size();i++){
            arrayTiempoVueltaSoloCopia.add(arrayTiempoVueltaSoloInicial.get(i));
        }
        arrayTiempoVueltaSoloInicial.clear();
    }

    public void copiarArrayString(ArrayList<String> arrayTiempoVueltaSoloInicial, ArrayList<String> arrayTiempoVueltaSoloCopia){
        for(int i = 0;i<arrayTiempoVueltaSoloInicial.size();i++){
            arrayTiempoVueltaSoloCopia.add(arrayTiempoVueltaSoloInicial.get(i));
        }
        arrayTiempoVueltaSoloInicial.clear();
    }

   /* public void ordenarArray(ArrayList<Rango> arrayTiempoVueltaSoloInicial){
        int minutes,seconds,miliseconds;
        for(int i = 0;i<arrayTiempoVueltaSoloInicial.size() - 1;i++){
            minutes = arrayTiempoVueltaSoloInicial.get(i).getMinutes();
            seconds = arrayTiempoVueltaSoloInicial.get(i).getSeconds();
            miliseconds = arrayTiempoVueltaSoloInicial.get(i).getMilliseconds();
            if ((arrayTiempoVueltaSoloInicial.get(i + 1).getSeconds() - seconds) < 0 || (arrayTiempoVueltaSoloInicial.get(i + 1).getMilliseconds() - miliseconds) < 0) {
                arrayTiempoVueltaSoloInicial.add(new Rango(arrayTiempoVueltaSoloInicial.get(i + 1).getMinutes(),arrayTiempoVueltaSoloInicial.get(i + 1).getSeconds(),arrayTiempoVueltaSoloInicial.get(i + 1).getMilliseconds()));
                arrayTiempoVueltaSoloInicial.set(i + 1,arrayTiempoVueltaSoloInicial.get(i));
                arrayTiempoVueltaSoloInicial.set(i,arrayTiempoVueltaSoloInicial.get(arrayTiempoVueltaSoloInicial.size() - 1));
                arrayTiempoVueltaSoloInicial.remove(arrayTiempoVueltaSoloInicial.size() - 1);
            }
        }
    }*/


   public void inicializarArray(ArrayList<Rango> array){
       for(int i=0;i< totalPilotos;i++){
           array.add(new Rango(0,0,0));
       }

   }
    public void ordenar(ArrayList<Rango> arrayTiempoVueltaSoloInicial, ArrayList<String> arrayTiempoVuelta, ArrayList<Coche> arrayCoche)
    {
        int masPequenio; // �ndice del elemento m�s peque�o

        // itera a trav�s de datos.size() - 1 elementos
        for ( int i = 0; i < arrayTiempoVueltaSoloInicial.size() - 1; i++ )
        {
            masPequenio = i; // primer �ndice del resto del arreglo

            // itera para buscar el �ndice del elemento m�s peque�o
            for ( int indice = i + 1; indice < arrayTiempoVueltaSoloInicial.size(); indice++ )
                if ( arrayTiempoVueltaSoloInicial.get(indice).getSeconds() == arrayTiempoVueltaSoloInicial.get(masPequenio).getSeconds()) {
                    if (arrayTiempoVueltaSoloInicial.get(indice).getMilliseconds() < arrayTiempoVueltaSoloInicial.get(masPequenio).getMilliseconds())
                        masPequenio = indice;
                }
                else if(arrayTiempoVueltaSoloInicial.get(indice).getSeconds() < arrayTiempoVueltaSoloInicial.get(masPequenio).getSeconds())
                    masPequenio = indice;

            intercambiar( i, masPequenio, arrayTiempoVueltaSoloInicial, arrayTiempoVuelta, arrayCoche ); // intercambia el elemento m�s peque�o en la posici�n
        } // fin de for exterior
    } // fin del m�todo ordenar

    // m�todo ayudante para intercambiar los valores de dos elementos
    public void intercambiar( int primero, int segundo, ArrayList<Rango> arrayTiempoVueltaSoloInicial, ArrayList<String> arrayTiempoVuelta, ArrayList<Coche> arrayCoche)
    {
        Rango temporal = arrayTiempoVueltaSoloInicial.get(primero); // almacena primero en temporal
        String temporal1 = arrayTiempoVuelta.get(primero);
        Coche temporal2 = arrayCoche.get(primero);
        arrayTiempoVueltaSoloInicial.set(primero,arrayTiempoVueltaSoloInicial.get(segundo)); // sustituye primero con segundo
        arrayTiempoVuelta.set(primero,arrayTiempoVuelta.get(segundo));
        arrayCoche.set(primero,arrayCoche.get(segundo));
        arrayTiempoVueltaSoloInicial.set(segundo,temporal); // coloca temporal en segundo
        arrayTiempoVuelta.set(segundo,temporal1);
        arrayCoche.set(segundo, temporal2);
    } // fin del m�todo intercambiar

    public void reordenarIndices(ArrayList<String> arrayTiempoVuelta){
        for(int i = 0;i < arrayTiempoVuelta.size();i++){
            arrayTiempoVuelta.set(i,arrayTiempoVuelta.get(i).replaceFirst(arrayTiempoVuelta.get(i).substring(0,1),Integer.toString(i+1)));
        }
    }
    public void stringArrayOrdenado(ArrayList<Rango> arrayList, ArrayList<String> arrayString, ArrayList<String> posNombrePiloto){
        int cont = 0;
        arrayString.clear();
        for (Rango r: arrayList) {
            //TODO
            arrayString.add((cont + 1) + ".-" + posNombrePiloto.get(cont).substring(0,3) + " = " + r.getMinutes() + ":" + r.getSeconds() + "," + r.getMilliseconds());
            cont++;
        }
    }

    public void ordenarNombres(ArrayList<String> abrev, ArrayList<String> arrayTiempoVueltaSoloInicial){
        for(int i = 0;i<arrayTiempoVueltaSoloInicial.size();i++){

        }
    }


    public void mejoraIAExponencial(ArrayList<Coche> arrayCoche, double porcentajeMejora){
        for(int i = 0; i <arrayCoche.size();i++){
            int a = aleatorio(0,2);
            switch (a) {
                case 0:
                    if (arrayCoche.get(i).getAceleracion() < 10 && arrayCoche.get(i).getAceleracion() * porcentajeMejora <= 10) {
                        if (arrayCoche.get(i).getAceleracion() == 0) {
                            arrayCoche.get(i).setAceleracion(arrayCoche.get(i).getAceleracion() + 1);
                        }
                        else
                            arrayCoche.get(i).setAceleracion(arrayCoche.get(i).getAceleracion() * porcentajeMejora);
                    }
                    else if(arrayCoche.get(i).getAceleracion() * porcentajeMejora >= 10)
                        arrayCoche.get(i).setAceleracion(10);
                    break;
                case 1:
                    if (arrayCoche.get(i).getAerodinamica() < 10 && arrayCoche.get(i).getAerodinamica() * porcentajeMejora <= 10) {
                        if(arrayCoche.get(i).getAerodinamica()==0){
                            arrayCoche.get(i).setAerodinamica(arrayCoche.get(i).getAerodinamica() + 1);
                        }
                        else
                            arrayCoche.get(i).setAerodinamica(arrayCoche.get(i).getAerodinamica() * porcentajeMejora);
                    }
                    else if(arrayCoche.get(i).getAerodinamica() * porcentajeMejora >= 10)
                        arrayCoche.get(i).setAerodinamica(10);
                    break;
                case 2:
                    if(arrayCoche.get(i).getVelocidad()<10 && arrayCoche.get(i).getVelocidad() * porcentajeMejora <= 10) {
                        if(arrayCoche.get(i).getVelocidad()==0){
                            arrayCoche.get(i).setVelocidad(arrayCoche.get(i).getVelocidad() + 1);
                        }
                        else
                            arrayCoche.get(i).setVelocidad(arrayCoche.get(i).getVelocidad() * porcentajeMejora);
                    }
                    else if(arrayCoche.get(i).getVelocidad() * porcentajeMejora >= 10)
                        arrayCoche.get(i).setVelocidad(10);
                    break;
                default:
                    a = aleatorio(0,2);
            }
        }
    }

    public static void main(String[] args){
        Gestion g = new Gestion();
        Duration[]duration = new Duration[2];
        duration[0] = duration[0].ofMillis(82648);
        duration[1] = duration[0].ofMillis(85648);


         // Circuito m = new Circuito("Melbourne", "Australia", 30, 3000.5, 0.0, path , duration);
        //g.arrayCircuito.add(m);
        g.creacionAI();
        for (Coche coche: g.arrayCoche) {
            System.out.println("Nombre: " + coche.getNombre() + " Escuderia: "+ coche.getEscuderia() + " Velocidad : " + coche.getVelocidad() + " Aceleracion : " + coche.getAceleracion() + " Aerodinamica: " + coche.getAerodinamica() + " Probabilidad Rotura: " + coche.getProbRotura());
        }
        g.mejoraIAExponencial(g.arrayCoche, 1.08);
        System.out.println("===============================================================================================\n");
        for (Coche coche: g.arrayCoche) {
            System.out.println("Nombre: " + coche.getNombre() + " Escuderia: "+ coche.getEscuderia() + " Velocidad : " + coche.getVelocidad() + " Aceleracion : " + coche.getAceleracion() + " Aerodinamica: " + coche.getAerodinamica() + " Probabilidad Rotura: " + coche.getProbRotura());
        }
        //prueba
    }
}
