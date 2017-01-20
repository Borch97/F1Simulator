package GUI.test;


import datos.Rango;

import java.awt.*;

public class testInformacion {

        private int pos;
        private String nombre;
        private String imagen;
        private String tiempo;
        private String Diferencia;
        private int paradasBoxes;

        public testInformacion(int pos,String nombre, String imagen, String tiempo, String diferencia, int paradasBoxes) {
            this.pos = pos;
            this.nombre = nombre;
            this.imagen = imagen;
            this.tiempo = tiempo;
            this.Diferencia = diferencia;
            this.paradasBoxes = paradasBoxes;
        }

        public testInformacion(){}

        public int getPos() { return pos; }

        public void setPos(int pos) { this.pos = pos; }

        public String getNombre() {
                return nombre;
            }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
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

        public void setParadasBoxes(int  paradasBoxes) {
            this.paradasBoxes = paradasBoxes;
        }
    }


