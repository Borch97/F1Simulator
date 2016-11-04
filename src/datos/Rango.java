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
}
