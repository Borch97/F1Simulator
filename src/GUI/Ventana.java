package GUI;

import datos.Circuito;
import datos.Gestion;
import datos.Rango;
import logica.Simulacion;

import java.awt.*;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame implements ActionListener {

    private JLabel texto;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton boton;          // boton con una determinada accion
    private JList clasificacionVuelta;
    Simulacion s = new Simulacion();
    Gestion g = new Gestion();

    public Ventana() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Esta Es Una Ventana");                   // colocamos titulo a la ventana
        this.setSize(1024, 720);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        this.setBackground(Color.blue);

    }

    //TODO
    private void test(){
        g.creacionAI();
        Circuito barcelona = new Circuito("Barcelona", "Espanya", 50, 50.0,"/pictures/Melbourne.png", 82648, 85648);
        g.arrayCircuito.add(barcelona);
        int cont = 0;
        Rango r;
        while (cont<g.totalPilotos) {
            r = s.tiempoVueltaInicial((int)barcelona.getRangoTiempoInicial(), (int)barcelona.getRangoTiempoFinal(),
                    g.arrayCoche.get(cont).getVelocidad(), g.arrayCoche.get(cont).getAceleracion(),g.arrayCoche.get(cont).getAerodinamica() );
            g.arrayTiempoVuelta.add((cont + 1)  + ".-" + g.arrayCoche.get(cont).getAbreviado() + " = " + r.getMinutes() + ":" + r.getSeconds() + "," + r.getMilliseconds());
            cont++;
        }
    }
    private void inicializarComponentes() {
        // creamos los componentes
        JLabel vueltas = new JLabel();
        clasificacionVuelta = new JList();
        texto = new JLabel();
        caja = new JTextField();
        boton = new JButton();
        // configuramos los componentes
        vueltas.setText("50" + "/" + "50");
        vueltas.setBounds(512, 30, 100,25);
        test();
        clasificacionVuelta.setListData( g.arrayTiempoVuelta.toArray());
        clasificacionVuelta.setBounds(20,90,150,300);
        clasificacionVuelta.setForeground(Color.green);
        clasificacionVuelta.setBackground(Color.BLACK);
        clasificacionVuelta.setOpaque(false);
        this.setIconImage(new ImageIcon(this.getClass().getResource(g.arrayCircuito.get(0).getFotoCircuito())).getImage());
        texto.setText("Inserte Nombre");    // colocamos un texto a la etiqueta
        texto.setBounds(50, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Mostrar Mensaje");   // colocamos un texto al boton
        boton.setBounds(50, 100, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        // adicionamos los componentes a la ventana
        //this.add(texto);
        //this.add(caja);
        //this.add(boton);
        this.add(vueltas);
        this.add(clasificacionVuelta);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
        JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");    // mostramos un mensaje (frame, mensaje)
    }

    public static void main(String[] args) {
        Ventana V = new Ventana();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
    }
}