package datos;


import java.awt.*;

public class informacionTabla {

    private String nombre;
    private Image imagen;
    private String tiempo;
    private String Diferencia;
    private int paradasBoxes;

    public informacionTabla(String nombre, Image imagen, String tiempo, String diferencia, int paradasBoxes) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.tiempo = tiempo;
        Diferencia = diferencia;
        this.paradasBoxes = paradasBoxes;
    }

    public informacionTabla(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getDiferencia() {
        return Diferencia;
    }

    public void setDiferencia(String diferencia) {
        Diferencia = diferencia;
    }

    public int getParadasBoxes() {
        return paradasBoxes;
    }

    public void setParadasBoxes(int paradasBoxes) {
        this.paradasBoxes = paradasBoxes;
    }
}
