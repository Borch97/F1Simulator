package datos;

// https://github.com/Borch97/F1Simulator.git
import java.awt.*;
import java.io.File;
import java.lang.Object;
import java.time.Duration;

public class Circuito {

    protected String nom_circuito;
    protected String pais;
    protected int vueltas;
    protected double probLluvia;
    protected String fotoCircuito;
    protected  long rangoTiempoInicial;
    protected long rangoTiempoFinal;


    /**
     * Contructor vacio con valores predeterminados
     */
    public Circuito(){
        nombre = " ";
        pais = " ";
        probLluvia = 0;
    }

    /**
     * Contructor para la creacion personalizada de un circuito
     * @param nombre
     * @param pais
     * @param vueltas
     * @param probLluvia
     * @param fotoCircuito
     * @param rangoTiempoInicial
     * @param rangoTiempoFinal
     */
    public Circuito(String nombre, String pais, int vueltas, double probLluvia, String fotoCircuito, long rangoTiempoInicial, long rangoTiempoFinal) {
        this.nombre = nombre;
        this.pais = pais;
        this.vueltas = vueltas;
        this.probLluvia = probLluvia;
        this.fotoCircuito = fotoCircuito;
        this.rangoTiempoInicial = rangoTiempoInicial;
        this.rangoTiempoFinal = rangoTiempoFinal;
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

    public double getProbLluvia() {
        return probLluvia;
    }

    public void setProbLluvia(double probLluvia) {
        this.probLluvia = probLluvia;
    }

    public String getFotoCircuito() {
        return fotoCircuito;
    }

    public void setFotoCircuito(String fotoCircuito) { this.fotoCircuito = fotoCircuito;
    }

    public long getRangoTiempoInicial() {  return rangoTiempoInicial;
    }

    public void setRangoTiempoInicial(long rangoTiempoInicial) {  this.rangoTiempoInicial = rangoTiempoInicial;
    }

    public long getRangoTiempoFinal() {    return rangoTiempoFinal;
    }

    public void setRangoTiempoFinal(long rangoTiempoFinal) {  this.rangoTiempoFinal = rangoTiempoFinal;
    }

    public static void main(String[] args){
        Circuito c = new Circuito();
        /*c.rangoTiempo[0] = c.rangoTiempo[0].ofSeconds(3600);
        System.out.println(c.rangoTiempo[0].toHours());
        System.out.println(c.rangoTiempo[0].toMinutes());*/

    }

}
