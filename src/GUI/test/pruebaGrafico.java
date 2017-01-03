package GUI.test;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class pruebaGrafico extends JPanel{

    private ArrayList<Integer> datos;
    private ArrayList<Integer> posicionX = new ArrayList<>();
    private ArrayList<Integer> posicionY = new ArrayList<>();
    private ArrayList<Double> separacionY = new ArrayList<>();
    private ArrayList<Double> separacionX = new ArrayList<>();

    public int aleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }
    public void recargarArray(ArrayList<Integer> array){
        array.clear();
        for(int i = 0;i<=10;i++) {
            array.add(aleatorio(1, 50));
        }
        ordenarArray(array);
    }
    public void ordenarArray(ArrayList<Integer> array){
            int masPequenio; // �ndice del elemento m�s peque�o

            // itera a trav�s de datos.size() - 1 elementos
            for ( int i = 0; i < array.size() - 1; i++ )
            {
                masPequenio = i; // primer �ndice del resto del arreglo

                // itera para buscar el �ndice del elemento m�s peque�o
                for ( int indice = i + 1; indice < array.size(); indice++ )
                    if(array.get(indice) < array.get(masPequenio))
                        masPequenio = indice;

                intercambiar( i, masPequenio, array ); // intercambia el elemento m�s peque�o en la posici�n
            } // fin de for exterior
        } // fin del m�todo ordenar

        // m�todo ayudante para intercambiar los valores de dos elementos
        public void intercambiar( int primero, int segundo, ArrayList<Integer> array)
        {
            int temporal = array.get(primero); // almacena primero en temporal
            array.set(primero,array.get(segundo)); // sustituye primero con segundo
            array.set(segundo,temporal); // coloca temporal en segundo
        } // fin del m�todo intercambiar

    public pruebaGrafico(){
        datos = new ArrayList<>();
        recargarArray(datos);
        setupPanel();
    }
    private void setupPanel(){
        calcularPosicionSeparacionX(50,separacionX);
        calcularPosicionSeparacionY(10,separacionY);
        for(int i= 0;i<=50;i++) {
            calcularCoordenadas(posicionX, posicionY, i, 1);
        }
    }

    public void paint (Graphics g)
    {
        super.paint(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor (Color.blue);
        g.drawLine (0, 70, 100, 70);
        /*g.drawRect (150, 70, 50, 70);
        g.drawRoundRect (250, 70, 50, 70, 6, 6);
        g.drawOval (350, 70, 50, 70);
        int [] vx1 = {500, 550, 450};
        int [] vy1 = {70, 120, 120};
        g.drawPolygon (vx1, vy1, 3);

        g.setColor (Color.red);
        g.fillRect (150, 270, 50, 70);
        g.fillRoundRect (250, 270, 50, 70, 6, 6);
        g.fillOval (350, 270, 50, 70);
        int [] vx2 = {500, 550, 450};
        int [] vy2 = {270, 320, 320};
        g.fillPolygon (vx2, vy2, 3);*/
    }

    private void calcularCoordenadas(ArrayList<Integer> X, ArrayList<Integer> Y, int vueltaActual, int posPiloto){
        X.add(posPiloto);
        Y.add(vueltaActual);
    }

    private double espacioSeparacionY(ArrayList<Integer> datos) {
        return this.getHeight() / datos.size();
    }
    private double espacioSeparacionX(ArrayList<Integer> datos, int vueltas){
        return this.getWidth()/vueltas;
    }

    private void calcularPosicionSeparacionX(int vueltas, ArrayList<Double> separacionX){
        double width = espacioSeparacionX(datos, 50);
        double temp = this.getHeight();
        for(int i = 0;i<=vueltas;i++){
            separacionX.add(temp-width);
            temp -=width;
            vueltas--;
        }
    }

    private void calcularPosicionSeparacionY(int pilotos, ArrayList<Double> separacionY ){
        double height = espacioSeparacionY(datos);
        double temp = this.getHeight();
        for(int i = 0;i<=pilotos;i++){
            separacionY.add(temp-height);
            temp -=height;
            pilotos--;
        }
    }

    public static void main(String[] args){
    }






}
