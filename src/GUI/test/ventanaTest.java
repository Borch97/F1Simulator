package GUI.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


    public class ventanaTest extends JFrame implements ActionListener {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        private JPanel panelPrincipal, panelTop, panelCentral, panelIzquierda;
        private JList JListClasificacion;
        private JLabel texto;           // etiqueta o texto no editable
        private JTextField caja;        // caja de texto, para insertar datos
        private JButton boton;          // boton con una determinada accion
        private pruebaGrafico grafico;

        public ventanaTest() {
            super();                    // usamos el contructor de la clase padre JFrame
            configurarVentana();        // configuramos la ventana
            inicializarComponentes();   // inicializamos los atributos o componentes
        }

        private void configurarVentana() {
            this.setTitle("Esta Es Una Ventana");                   // colocamos titulo a la ventana
            this.setSize(screenSize);                                 // colocamos tamanio a la ventana (ancho, alto)
            this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
            this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
            this.setResizable(true);                               // hacemos que la ventana no sea redimiensionable
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        }

        private void inicializarComponentes() {
            // creamos los componentes
            panelPrincipal = new JPanel();
            panelTop = new JPanel();
            panelCentral = new JPanel();
            panelIzquierda = new JPanel();
            panelPrincipal.setLayout(new BorderLayout());
            panelTop.setLayout(new BorderLayout());
            panelCentral.setLayout(new BorderLayout());
            panelIzquierda.setLayout(new BorderLayout());
            texto = new JLabel();
            caja = new JTextField();
            boton = new JButton();
            boton.setText("Prueba");
            grafico = new pruebaGrafico();
            // configuramos los componentes
            texto.setText("Inserte Nombre");    // colocamos un texto a la etiqueta
            texto.setBounds(50, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
            boton.setText("Mostrar Mensaje");   // colocamos un texto al boton
            boton.setBounds(50, 100, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
            boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
            grafico.setBounds(0,0,this.getWidth(),this.getHeight());
            // adicionamos los componentes a la ventana
            //this.add(texto);
            //this.add(caja);
            //this.add(boton);
            panelPrincipal.add(grafico, BorderLayout.WEST);
            panelPrincipal.add(boton, BorderLayout.CENTER);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
            JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");    // mostramos un mensaje (frame, mensaje)
        }

        public static void main(String[] args) {
            ventanaTest V = new ventanaTest();      // creamos una ventana
            V.add( V.panelPrincipal, BorderLayout.CENTER );
            V.setVisible(true);             // hacemos visible la ventana creada
        }
    }

