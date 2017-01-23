package datos;


import java.io.File;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import BD.GestorBD;

import javax.swing.*;

public class Gestion {

    public static Gestion g = new Gestion();
    public final int totalPilotos = 10;
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
    public String[] informacionClasificaion = new String[totalPilotos];
    public ArrayList<informacionTabla> informacionTabla = new ArrayList<>();
    public ArrayList<Rango> arrayDiferenciaTiempo = new ArrayList<>();
    public ArrayList<Usuario> arrayUsuario; //= new ArrayList<>();
    //poner el nombre final a este String para crear su variable en la base de datos
    public String variableUsuario;
    public int contCircuito = 0;
    public int dinero = 50000;
    public ArrayList<Coche> arrayCocheClasificacion;
    //Obtener nombre y escuderia de la base de datos
    
    public Gestion()
    {
    	arrayNombres = GestorBD.getInstance().obtenerInfoPilotos();
    	arrayEscuderias = GestorBD.getInstance().obtenerInfoEscuderias();
        arrayCircuito = GestorBD.getInstance().obtenerInfoCircuito();
        arrayUsuario = GestorBD.getInstance().obtenerInfoUsuario();
        arrayCoche = GestorBD.getInstance().obtenerInfoCoches();
    }

    public int buscarPiloto(ArrayList<Coche> arrayCoche, String nombre){
        int pos = 0;
        int i = 0;
        for (Coche c : arrayCoche){
            if(c.getNom_piloto() == nombre){
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

    public void arrayListToArray(){
        int cont = 0;
        for(Coche c: arrayCoche){
            if(c.getNom_usuario().equals(variableUsuario)) {
                informacionClasificaion[cont] = cont + 1 + ".- " + c.getNom_piloto();
                cont++;
            }
        }
    }

    public void creacionPartidaNueva(){
        creacionUsuario();
        creacionUsuarioCoche();
        creacionAI();
    }

    public int obtenerPosicion(){
        for(int i = 0;i<arrayCoche.size();i++){
            if(arrayCoche.get(i).getNom_piloto().equals(variableUsuario))
                return i;
        }
        return 0;
    }

    public int obtenerPosicionUsuario(){
        for(int i = 0;i<arrayUsuario.size();i++){
            if(arrayUsuario.get(i).getNom_piloto().equals(variableUsuario))
                return i;
        }
        return 0;
    }

    public void agregarDinero(){
        switch (obtenerPosicion()){
            case 0:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 110000);
                break;
            case 1:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 100000);
                break;
            case 2:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 90000);
                break;
            case 3:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 80000);
                break;
            case 4:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 70000);
                break;
            case 5:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 60000);
                break;
            case 6:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 50000);
                break;
            case 7:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 40000);
                break;
            case 8:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 30000);
                break;
            case 9:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 20000);
                break;
            case 10:
                arrayUsuario.get(obtenerPosicionUsuario()).setDinero(arrayUsuario.get(obtenerPosicionUsuario()).getDinero() + 10000);
                break;
            default:
                break;
        }
    }



    //Crea un piloto nuevo completamente aleatorio

    /**
     * Crea un nuevo piloto de tipo Coche con todos los valores aleatorios, incluidos el nombre y la escuderia, basandose en un array de Strings
     * @return Devuelve un nuevo piloto de tipo Coche con todos los valores aleatorios
     */
    public Coche creacionPiloto(){
    	
    	String nombrepiloto = arrayNombres.get(aleatorio(0, arrayNombres.size() - 1));
		String nombreescuderia = arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1));
        String nombreUsuario = variableUsuario;
        //TODO añadir imagen coche
        Rango r = new Rango(0,0,0);
		return new Coche(nombrepiloto, " ", nombreescuderia, aleatorio(0, 10), aleatorio(0, 10), aleatorio(0, 10), 0,
				100, null, 0, variableUsuario,0, r );
    	// return new Coche(arrayNombres.get(aleatorio(0, arrayNombres.size() - 1))," ", arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1)), aleatorio(0, 10), aleatorio(0, 10), aleatorio(0, 10), 0, 100);
    }

    public void creacionUsuario(){
        Rango r = new Rango(0,0,0);
        Usuario u = new Usuario(variableUsuario,variableUsuario.substring(0,4),arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1)), 0,0,0,0,100,null,0,variableUsuario,0,2000000, 0, r);
        arrayUsuario.add(u);
        GestorBD.getInstance().guardarDatosUsuario(u);
    }
    public void creacionUsuarioCoche(){
        Rango r = new Rango(0,0,0);
        Coche c = new Coche(variableUsuario,variableUsuario.substring(0,4),arrayEscuderias.get(aleatorio(0, arrayEscuderias.size() - 1)), 0,0,0,0,100,null,0,variableUsuario,0, r);
        arrayCoche.add(c);
        GestorBD.getInstance().guardarDatosCoche(c);
    }


    public void resetearTiempo(){
        for(Coche c: arrayCoche){
            c.setTiempo(new Rango(0,0,0));
        }
    }

    public void guardarCoches(){
        for(Coche c : arrayCoche){
            GestorBD.getInstance().guardarDatosCoche(c);
        }
    }

    public void puntosCarrera(){
        int puntos = 100;
        for(int i = 0;i < arrayCoche.size();i++){
            arrayCoche.get(i).setPuntos(arrayCoche.get(i).getPuntos() + puntos);
            if(puntos > 0)
                puntos -= 10;
        }
    }

    public boolean comprobarUsuario(){
        boolean comp = false;
        int cont = 0;
        for(Coche c : arrayCoche){
            if(c.getNom_usuario().equals(variableUsuario))
                cont++;
        }
        if(cont == 1)
            comp = true;

        return comp;
    }
    //Metodo que se encarga de crear automaticamente todos los otros pilotos del modo carrera

    /**
     * Metodo que crea todos los coches de la AI del juego, comprobando que que no se repita el nombre y haya un maximo de dos pilotos por escuderia
     * Crea un numero de pilotos igual a la variable totalPilotos.
     */
    public void creacionAI(){
        // while(arrayCoche.isEmpty() || arrayCoche.size()<totalPilotos) {
              Coche cocheComprobar;
        if(arrayCoche.isEmpty() || arrayCoche.get(0).getNom_piloto().equals(variableUsuario) || comprobarUsuario()) {
            for (int j = totalPilotos - 1; j > 0; j--) {
                cocheComprobar = creacionPiloto();
                while ((containsElement(arrayCoche, cocheComprobar.getNom_piloto())) || contains2Elements(arrayCoche, cocheComprobar.getEscuderia())) {
                    cocheComprobar = creacionPiloto();
                }
                cocheComprobar.setAbreviado(cocheComprobar.getNom_piloto().substring(0, 4));
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
            if(coche.getNom_piloto().equals(nombre) && coche.getNom_usuario().equals(variableUsuario)){
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
            if(coche.getEscuderia().equals(escuderia) && coche.getNom_usuario().equals(variableUsuario)){
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

    public void copiarArrayCoche(ArrayList<Coche> arrayCoche, ArrayList<Coche> arrayCocheClasificacion){
        for(int i = 0;i<arrayCoche.size();i++){
            arrayCocheClasificacion.add(arrayCoche.get(i));
        }
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
    public void inicializarArrayCoche(ArrayList<Coche> array){
        for(int i=0;i< totalPilotos;i++){
            array.add(new Coche());
        }

    }

    public int buscarPosicion(String nombre){
        int pos = 0;
        for(int i = 0; i< arrayCoche.size();i++){
            if(arrayCoche.get(i).getNom_piloto().equals(nombre)) {
                pos = i;
                break;
            }
        }
        return pos;

    }
    public void resetearInformacion(){
        arrayDiferenciaTiempoVuelta.clear();
        arrayDiferenciaTiempo.clear();
        for (Coche c: arrayCoche) {
            c.setNeumaticos(100);
            c.setParadasBoxes(0);
            c.setProb_rotura(0);
        }
    }

    public void ordenarPorPuntos(ArrayList<Coche> arrayCocheClasificacion) {
        int masGrande; // �ndice del elemento m�s peque�o

        // itera a trav�s de datos.size() - 1 elementos
        for (int i = 0; i < arrayCocheClasificacion.size() - 1; i++) {
            masGrande = i; // primer �ndice del resto del arreglo

            // itera para buscar el �ndice del elemento m�s peque�o
            for (int indice = i + 1; indice < arrayCocheClasificacion.size(); indice++) {
                if (arrayCocheClasificacion.get(indice).getPuntos() == (arrayCocheClasificacion.get(masGrande).getPuntos()))
                    break;
                if (arrayCocheClasificacion.get(indice).getPuntos()> arrayCocheClasificacion.get(masGrande).getPuntos())
                    masGrande = indice;
            }

            intercambiar1(i, masGrande,arrayCocheClasificacion); // intercambia el elemento m�s peque�o en la posici�n
        }
    }

    // m�todo ayudante para intercambiar los valores de dos elementos
    public void intercambiar1( int primero, int segundo, ArrayList<Coche> arrayCocheClasificacion)
    {
        Coche temporal = arrayCocheClasificacion.get(primero);
        arrayCocheClasificacion.set(primero,arrayCocheClasificacion.get(segundo));
        arrayCoche.set(segundo, temporal);
    } // fin del m�todo intercambiar*/
    public void ordenarPorTiempoTotal(ArrayList<Coche> arrayCoche) {
        int masPequenio; // �ndice del elemento m�s peque�o

        // itera a trav�s de datos.size() - 1 elementos
        for (int i = 0; i < arrayCoche.size() - 1; i++) {
            masPequenio = i; // primer �ndice del resto del arreglo


            // itera para buscar el �ndice del elemento m�s peque�o
            for (int indice = i + 1; indice < arrayCoche.size(); indice++) {
                if (arrayCoche.get(indice).getNom_usuario().equals(variableUsuario) && arrayCoche.get(masPequenio).getNom_usuario().equals(variableUsuario)) {
                    if (arrayCoche.get(indice).getTiempo().equals(arrayCoche.get(masPequenio).getTiempo()))
                        break;
                    if (arrayCoche.get(indice).getTiempo().getMinutes() < arrayCoche.get(masPequenio).getTiempo().getMinutes())
                        masPequenio = indice;
                    else if (((arrayCoche.get(indice).getTiempo().getMinutes() == (arrayCoche.get(masPequenio).getTiempo().getMinutes())) && (arrayCoche.get(indice).getTiempo().getSeconds() < arrayCoche.get(masPequenio).getTiempo().getSeconds())))
                        masPequenio = indice;
                    else if (((arrayCoche.get(indice).getTiempo().getMinutes() == (arrayCoche.get(masPequenio).getTiempo().getMinutes())) && (arrayCoche.get(indice).getTiempo().getSeconds() == (arrayCoche.get(masPequenio).getTiempo().getSeconds())) && (arrayCoche.get(indice).getTiempo().getMilliseconds() < arrayCoche.get(masPequenio).getTiempo().getMilliseconds())))
                        masPequenio = indice;
                }
            }

            intercambiar2(i, masPequenio, arrayCoche); // intercambia el elemento m�s peque�o en la posici�n
        }
    }// fin de for exterior


    // m�todo ayudante para intercambiar los valores de dos elementos
    public void intercambiar2( int primero, int segundo, ArrayList<Coche> arrayCoche)
    {
        Coche temporal2 = arrayCoche.get(primero);
        arrayCoche.set(primero,arrayCoche.get(segundo));
        arrayCoche.set(segundo, temporal2);
    } // fin del m�todo intercambiar

    public void ordenarDiferencias(ArrayList<Rango> arrayDiferenciaTiempoVuelta, ArrayList<Rango> arrayTiempoVueltaSoloInicial, ArrayList<Coche> piloto){
        int masPequenio; // �ndice del elemento m�s peque�o

        // itera a trav�s de datos.size() - 1 elementos
        for (int i = 0; i < arrayDiferenciaTiempoVuelta.size() - 1; i++) {
            masPequenio = i; // primer �ndice del resto del arreglo


            // itera para buscar el �ndice del elemento m�s peque�o
            for (int indice = i + 1; indice < arrayDiferenciaTiempoVuelta.size(); indice++) {
                    if (arrayDiferenciaTiempoVuelta.get(indice).getMinutes() == (arrayDiferenciaTiempoVuelta.get(masPequenio).getMinutes()))
                        break;
                    if (arrayDiferenciaTiempoVuelta.get(indice).getMinutes() < arrayDiferenciaTiempoVuelta.get(masPequenio).getMinutes())
                        masPequenio = indice;
                    else if (((arrayDiferenciaTiempoVuelta.get(indice).getMinutes() == (arrayDiferenciaTiempoVuelta.get(masPequenio).getMinutes())) && (arrayDiferenciaTiempoVuelta.get(indice).getSeconds() < arrayDiferenciaTiempoVuelta.get(masPequenio).getSeconds())))
                        masPequenio = indice;
                    else if (((arrayDiferenciaTiempoVuelta.get(indice).getMinutes() == (arrayDiferenciaTiempoVuelta.get(masPequenio).getMinutes())) && (arrayDiferenciaTiempoVuelta.get(indice).getSeconds() == (arrayDiferenciaTiempoVuelta.get(masPequenio).getSeconds())) && (arrayDiferenciaTiempoVuelta.get(indice).getMilliseconds() < arrayDiferenciaTiempoVuelta.get(masPequenio).getMilliseconds())))
                        masPequenio = indice;

            }

            intercambiar(i, masPequenio, arrayDiferenciaTiempoVuelta, arrayTiempoVueltaSoloInicial, piloto); // intercambia el elemento m�s peque�o en la posici�n
        }
    }// fin de for exterior


    // m�todo ayudante para intercambiar los valores de dos elementos
    public void intercambiar( int primero, int segundo, ArrayList<Rango> arrayDiferenciaTiempo, ArrayList<Rango> arrayTiempoVueltaSoloInicial, ArrayList<Coche> piloto)
    {
        Rango temporal3 = arrayDiferenciaTiempo.get(primero);
        Coche temporal = piloto.get(primero);
        Rango temporal1 = arrayTiempoVueltaSoloInicial.get(primero);
        arrayDiferenciaTiempo.set(primero, arrayDiferenciaTiempo.get(segundo));
        piloto.set(primero, piloto.get(segundo));
        arrayTiempoVueltaSoloInicial.set(primero, arrayTiempoVueltaSoloInicial.get(segundo));
        arrayDiferenciaTiempo.set(segundo,temporal3);
        piloto.set(segundo, temporal);
        arrayTiempoVueltaSoloInicial.set(segundo,temporal1);
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
            System.out.println("Nombre: " + coche.getNom_piloto() + " Escuderia: "+ coche.getEscuderia() + " Velocidad : " + coche.getVelocidad() + " Aceleracion : " + coche.getAceleracion() + " Aerodinamica: " + coche.getAerodinamica() + " Probabilidad Rotura: " + coche.getProb_rotura());
        }
        g.mejoraIAExponencial(g.arrayCoche, 1.08);
        System.out.println("===============================================================================================\n");
        for (Coche coche: g.arrayCoche) {
            System.out.println("Nombre: " + coche.getNom_piloto() + " Escuderia: "+ coche.getEscuderia() + " Velocidad : " + coche.getVelocidad() + " Aceleracion : " + coche.getAceleracion() + " Aerodinamica: " + coche.getAerodinamica() + " Probabilidad Rotura: " + coche.getProb_rotura());
        }
        //prueba
    }
}
