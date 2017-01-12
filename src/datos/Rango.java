package datos;

public class Rango {

    protected int minutes;
    protected int seconds;
    protected int milliseconds;

    /**
     * Contructor para la creacion personalizada de un rango
     * @param minutes
     * @param seconds
     * @param milliseconds
     */
    public Rango(int minutes, int seconds, int milliseconds) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }


    /**
     * Contructor Vacio
     */
    public Rango(){}

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public static void main(String[] args){
        Rango r1;
        int minutes = 1;
        int seconds = 22;
        int miliseconds = 876;
        Rango r = new Rango(1,21,777);
        r1 = new Rango(minutes,seconds,miliseconds);
        System.out.println( "Minutes: " + (r.getMinutes() - r1.getMinutes()) + " Seconds: " + (r.getSeconds() - r1.getSeconds()) + " Miliseconds: " + (r.getMilliseconds() - r1.getMilliseconds()));

    }
}
