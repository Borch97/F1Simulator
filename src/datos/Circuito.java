package datos;


import java.io.File;
import java.lang.Object;
import java.time.Duration;

public class Circuito {

    protected String nombre;
    protected String pais;
    protected int vueltas;
    protected double distancia;
    protected double probLluvia;
    protected File fotoCircuito;
    protected Duration[] rangoTiempo = new Duration[2];



    public Circuito(){
        nombre = " ";
        pais = " ";
        probLluvia = 0;
    }

    public Circuito(String nombre, String pais, int vueltas, double distancia, double probLluvia, File fotoCircuito, Duration[] rangoTiempo) {
        this.nombre = nombre;
        this.pais = pais;
        this.vueltas = vueltas;
        this.distancia = distancia;
        this.probLluvia = probLluvia;
        this.fotoCircuito = fotoCircuito;
        this.rangoTiempo = rangoTiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getProbLluvia() {
        return probLluvia;
    }

    public void setProbLluvia(double probLluvia) {
        this.probLluvia = probLluvia;
    }

    public File getFotoCircuito() {
        return fotoCircuito;
    }

    public void setFotoCircuito(File fotoCircuito) {
        this.fotoCircuito = fotoCircuito;
    }

    public Object[] getRangoTiempo() {
        return rangoTiempo;
    }

    public void setRangoTiempo(Duration[] rangoTiempo) {
        this.rangoTiempo = rangoTiempo;
    }


    public static void main(String[] args){
        Circuito c = new Circuito();
        c.rangoTiempo[0] = c.rangoTiempo[0].ofSeconds(3600);
        System.out.println(c.rangoTiempo[0].toHours());
        System.out.println(c.rangoTiempo[0].toMinutes());

    }

}
