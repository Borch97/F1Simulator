package GUI;

import GUI.test.fondoVentana;
import GUI.test.test2;
import GUI.test.testInformacion;
import datos.Circuito;
import datos.Gestion;
import datos.informacionTableModel;
import logica.Simulacion;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Clase Ventanaa
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 */
public class Ventana extends JFrame implements ActionListener{

    private JPanel panelPrincipal, panelTop, panelCentral, panelIzquierda, panelNeumaticos, panelNeumaticosArriba, panelNeumaticosAbajo, panelCircuito, panelTiempo;
    private JLabel texto, vueltas, neumaticos;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton boton, bDiferencia, boxes;
    private JTable tablaClasificacion;
    private static JList clasificacionVuelta, clasificacionVueltaDiferencia;
    private JLabelGrafico o = new JLabelGrafico( "/pictures/sun.png", true, 128, 128, 0.0 );
    private fondoVentana fV;
    public JProgressBar progressBarUR, progressBarUL, progressBarDR, progressBarDL;
    private Image circuitoFoto;
    private int cont = 0;
    hilo hilo1 = null;
    Thread hiloRotacion = new Thread(new hiloRotacion());
    DefaultListModel listModelVuelta, listModelDiferenciaVueltas;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static Rectangle tamanyoPanel = null;
    private static HashMap<Object,Rectangle> tamComponentes = new HashMap<>();
    TableModel tableModel = new informacionTableModel(Gestion.g.informacionTabla);
    DefaultTableModel model;
    private int seleccion;
    private int temp = 0;
    private ListSelectionModel selectionModel;


    public Ventana() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
        addRowToJTable();
    }

    private void configurarVentana() {
        this.setTitle("Progreso de la carrera");                   // colocamos titulo a la ventana
        this.setSize(screenSize);//(int) screenSize.getWidth(),(int)screenSize.getHeight()); // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setResizable(true);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso


    }

    //TODO
    public void test(){
        Simulacion.s.simulacionVueltas(Gestion.g.arrayCircuito,0,Gestion.g.arrayCoche,Gestion.g.arrayTiempoVuelta,Gestion.g.arrayTiempoVueltaSoloInicial,Gestion.g.posPiloto, true);
    }

    public ArrayList listPilots()
    {
        ArrayList<testInformacion> list = new ArrayList<>();

        for(int i = 0;i<Gestion.g.totalPilotos;i++){
            testInformacion info = new testInformacion(i + 1,Gestion.g.arrayCoche.get(i).getNom_piloto(),Gestion.g.arrayCoche.get(i).getEscuderia(),Gestion.g.arrayTiempoVueltaSoloInicial.get(i).getMinutes() + ":" + Gestion.g.arrayTiempoVueltaSoloInicial.get(i).getSeconds() + "," +
                    Gestion.g.arrayTiempoVueltaSoloInicial.get(i).getMilliseconds()," + " + Gestion.g.arrayDiferenciaTiempoVuelta.get(i).getSeconds() + "," + Gestion.g.arrayDiferenciaTiempoVuelta.get(i).getMilliseconds(),Gestion.g.arrayCoche.get(i).getParadasBoxes());
            list.add(info);
        }
        return list;
    }

    // added rows from arraylist to jtable
    public void addRowToJTable() {
        model = (DefaultTableModel) tablaClasificacion.getModel();
        ArrayList<testInformacion> list = listPilots();
        Object rowData[] = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getPos();
            rowData[1] = list.get(i).getNombre();
            rowData[2] = list.get(i).getImagen();
            rowData[3] = list.get(i).getTiempo();
            rowData[4] = list.get(i).getDiferencia();
            rowData[5] = list.get(i).getParadasBoxes();
            model.addRow(rowData);
        }

    }

    public void updateModel(){
        model.setRowCount(0);
        addRowToJTable();
        tablaClasificacion.setModel(model);

    }
    private void inicializarComponentes() {
        // creamos los componentes
        panelPrincipal = new JPanel();
        panelTop = new JPanel();
        panelCentral = new JPanel();
        panelIzquierda = new JPanel();
        panelNeumaticos = new JPanel();
        panelNeumaticosArriba = new JPanel();
        panelNeumaticosAbajo = new JPanel();
        panelCircuito = new JPanel();
        panelTiempo = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelTop.setLayout(new BorderLayout());
        panelCentral.setLayout(new BorderLayout());
        panelIzquierda.setLayout(new BorderLayout());
        panelNeumaticos.setLayout(new BorderLayout());
        panelNeumaticosArriba.setLayout(new BorderLayout());
        panelNeumaticosAbajo.setLayout(new BorderLayout());
        panelCircuito.setLayout(new BorderLayout());
        panelTiempo.setLayout(null);
        //panelCentral.setOpaque(true);
        fV = new fondoVentana(Color.gray);
        tablaClasificacion = new JTable();
        selectionModel = tablaClasificacion.getSelectionModel();
        circuitoFoto = new ImageIcon(this.getClass().getResource(Gestion.g.arrayCircuito.get(Gestion.g.contCircuito).getFoto_circ())).getImage();
        listModelVuelta = listModelDiferenciaVueltas = new DefaultListModel();
        modeloJlist(Gestion.g.arrayTiempoVuelta, listModelVuelta);
        vueltas = new JLabel();
        vueltas.setHorizontalAlignment(JLabel.CENTER);
        vueltas.setVerticalAlignment(JLabel.CENTER);
        neumaticos = new JLabel(new ImageIcon(this.getClass().getResource("/pictures/neumaticos.png")));
        clasificacionVuelta = new JList(listModelVuelta);
        clasificacionVueltaDiferencia = new JList(listModelDiferenciaVueltas);
        caja = new JTextField();
        boton = new JButton();
        boxes = new JButton();
        bDiferencia = new JButton();
        texto = new JLabel(new ImageIcon(circuitoFoto));
        texto.setSize(320,200);
        progressBarUR = progressBarUL = progressBarDR = progressBarDL = new JProgressBar();

        // configuramos los componentes

        String[] columnNames = {"Posición", "Nombre", "Coche", "Tiempo", "Diferencia", "P. Boxes"};
        model = new DefaultTableModel(columnNames, 0);
        tablaClasificacion.setModel(model);
        JScrollPane skrol = new JScrollPane(tablaClasificacion);


        /*this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {  // Al activarse la ventana almacenamos el tamaño del panel
                tamanyoPanel = this.panelPrincipal.getBounds();
                for (Component c : this.panelPrincipal.getComponents()) {
                    tamComponentes.put( c, c.getBounds() );  // Guardamos el tamaño y posición inicial de cada componente para luego escalarlo con él
                }
            }
        });
        this.panelPrincipal.addComponentListener( new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {  // Al redimensionarse el panel, reajustamos sus componentes
                if (this.panelPrincipal!=null && tamanyoPanel!=null) {
                    double escalaX = this.panelPrincipal.getWidth() / tamanyoPanel.getWidth();   // Nueva escala X
                    double escalaY = this.panelPrincipal.getHeight() / tamanyoPanel.getHeight(); // Nueva escala Y
                    for (Component c : this.panelPrincipal.getComponents()) {
                        Rectangle tamanyoInicial = tamComponentes.get( c );
                        if (c!=null) {
                            c.setSize( new Dimension( (int) (tamanyoInicial.getWidth()*escalaX), (int)(tamanyoInicial.getHeight()*escalaY) ) );
                            c.setLocation( (int) (tamanyoInicial.getX()*escalaX), (int)(tamanyoInicial.getY()*escalaY) );
                        }
                    }
                }
            }
        });*/
        this.getContentPane().add( this.panelPrincipal, BorderLayout.CENTER );
        Gestion.g.inicializarArray(Gestion.g.arrayDiferenciaTiempoVuelta);
        panelPrincipal.setSize(screenSize);
        neumaticos.setSize(181,272);
        neumaticos.setBounds(1600,370,181,272);
        vueltas.setText(" 50 " + " / " + " 50 ");
        vueltas.setForeground(Color.BLACK);
        //vueltas.setBorder(new LineBorder(Color.black));
        //vueltas.setBounds(640, 30, 42,22);
        vueltas.setBounds((int)(screenSize.getWidth())/2,(int)(screenSize.getHeight() - screenSize.getHeight()) + 30,55,20);
        vueltas.setOpaque(false);
        progressBarUR = new JProgressBar(0, 100);
        progressBarUR.setValue(100);
        progressBarUR.setStringPainted(true);
        progressBarUR.setBounds(1750,407,50,30);
        progressBarUL = new JProgressBar(0, 100);
        progressBarUL.setValue(100);
        progressBarUL.setStringPainted(true);
        progressBarUL.setBounds(1580,407,50,30);
        progressBarDR = new JProgressBar(0, 100);
        progressBarDR.setValue(100);
        progressBarDR.setStringPainted(true);
        progressBarDR.setBounds(1750,580,50,30);
        progressBarDL = new JProgressBar(0, 100);
        progressBarDL.setValue(100);
        progressBarDL.setStringPainted(true);
        progressBarDL.setBounds(1580,580,50,30);
        //progressBar.setOpaque(false);
        clasificacionVuelta.setBackground(new Color(64,64,64,0));//Color(rojo,verde,azul,opacidad)
        clasificacionVueltaDiferencia.setBackground(new Color(0,0,0,0));
        //clasificacionVuelta.setListData( g.arrayTiempoVuelta.toArray());
        clasificacionVuelta.setBounds(20,90,120,200);
        clasificacionVuelta.setForeground(Color.BLACK);
        clasificacionVuelta.setOpaque(false);
        clasificacionVueltaDiferencia.setBounds(20,90,200,300);
        clasificacionVueltaDiferencia.setForeground(Color.BLACK);
        clasificacionVueltaDiferencia.setOpaque(false);
        this.setIconImage(new ImageIcon(this.getClass().getResource(Gestion.g.arrayCircuito.get(0).getFotoCircuito())).getImage());
        //caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Comenzar carrera");   // colocamos un texto al boton
        boton.setBounds((int)(screenSize.getWidth()/2)/2,(int)screenSize.getHeight() - 100, 150, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.setBackground(new Color(0,0,0,0));
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        boton.setOpaque(false);
        bDiferencia.setBounds((int)screenSize.getWidth()/2,(int)screenSize.getHeight() - 100,150,30);
        bDiferencia.setText("Diferencia/Tiempos");
        bDiferencia.setBackground(new Color(0,0,0,0));
        bDiferencia.setOpaque(false);
        o.setHorizontalAlignment(SwingConstants.CENTER);
        o.setBounds(80,400,128,128);
        boxes.setBounds((boton.getX() + bDiferencia.getX())/ 2,(int)screenSize.getHeight() - 100,150,30);
        boxes.setText("Boxes");
        boxes.setOpaque(false);
        boxes.setBackground(new Color(0,0,0,0));
        bDiferencia.addActionListener(e -> {
            if(clasificacionVuelta.isVisible()) {
                clasificacionVuelta.setVisible(false);
                clasificacionVueltaDiferencia.setVisible(true);
            }
            else {
                clasificacionVuelta.setVisible(true);
                clasificacionVueltaDiferencia.setVisible(false);
            }
        });
        tablaClasificacion.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if(tablaClasificacion.getSelectedRow() == -1) {
                    seleccion = 0;
                    selectionModel.setSelectionInterval(temp, temp);
                }
                else if(tablaClasificacion.getSelectedRow() >= 0 && tablaClasificacion.getSelectedRow()<Gestion.g.totalPilotos) {
                    seleccion = tablaClasificacion.getSelectedRow();
                    temp = seleccion;
                    selectionModel.setSelectionInterval(seleccion, seleccion);
                }
            }
        });
       /* DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tablaClasificacion.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );*/
        // adicionamos los componentes a la ventana
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.add(panelTop, BorderLayout.NORTH);
        panelPrincipal.add(panelIzquierda, BorderLayout.WEST);
        panelNeumaticos.add(panelNeumaticosArriba, BorderLayout.NORTH);
        panelNeumaticos.add(panelNeumaticosAbajo, BorderLayout.SOUTH);
        panelIzquierda.add(panelNeumaticos, BorderLayout.SOUTH);
        panelIzquierda.add(panelCircuito, BorderLayout.BEFORE_FIRST_LINE);
        panelIzquierda.add(panelTiempo, BorderLayout.CENTER);
        //panelCentral.add(tablaClasificacion.getTableHeader(), BorderLayout.PAGE_START);
        panelCentral.add(skrol, BorderLayout.CENTER);
        //panelCentral.add(vueltas,BorderLayout.CENTER);
        //panelIzquierda.add(texto, BorderLayout.NORTH);

        //this.add(caja);
        //panelPrincipal.add(boton);
        panelTop.add(vueltas, BorderLayout.CENTER);
        panelCircuito.add(texto, BorderLayout.CENTER);
        panelTiempo.add(o);
        //panelPrincipal.add(clasificacionVuelta);
        //this.add(clasificacionVueltaDiferencia);
        //panelPrincipal.add(bDiferencia);
        panelNeumaticosArriba.add(progressBarUR, BorderLayout.EAST);
        panelNeumaticosArriba.add(progressBarUL, BorderLayout.WEST);
        panelNeumaticosAbajo.add(progressBarDR, BorderLayout.EAST);
        panelNeumaticosAbajo.add(progressBarDL, BorderLayout.WEST);
        //panelPrincipal.add(neumaticos);
        //panelPrincipal.add(o);
        panelTop.add(boton, BorderLayout.WEST);
        //panelPrincipal.add(texto);
        hiloRotacion.start();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(hilo1 == null) {
           crearThread();
        }
        if(!crearThread().isAlive()) {
            crearThread().start();
        }
        //String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
        //JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");    // mostramos un mensaje (frame, mensaje)
    }


    public Thread crearThread(){
        this.hilo1 = this.new hilo();
        Thread crearHilo = new Thread(this.hilo1);

        return crearHilo;
    }




    public void modeloJlist(ArrayList<String> tiempoVuelta, DefaultListModel listModel){
        tiempoVuelta.forEach(listModel::addElement);
    }

    public static void main(String[] args) {
        Ventana V = new Ventana(); // creamos una ventana
        //TODO fuera del main
        V.addWindowListener( new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {  // Al activarse la ventana almacenamos el tamaño del panel
                tamanyoPanel = V.panelPrincipal.getBounds();
                for (Component c : V.panelPrincipal.getComponents()) {
                    tamComponentes.put( c, c.getBounds() );  // Guardamos el tamaño y posición inicial de cada componente para luego escalarlo con él
                }
            }
        });
        V.panelPrincipal.addComponentListener( new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {  // Al redimensionarse el panel, reajustamos sus componentes
                if (V.panelPrincipal!=null && tamanyoPanel!=null) {
                    double escalaX = V.panelPrincipal.getWidth() / tamanyoPanel.getWidth();   // Nueva escala X
                    double escalaY = V.panelPrincipal.getHeight() / tamanyoPanel.getHeight(); // Nueva escala Y
                    for (Component c : V.panelPrincipal.getComponents()) {
                        Rectangle tamanyoInicial = tamComponentes.get( c );
                        if (c!=null) {
                            c.setSize( new Dimension( (int) (tamanyoInicial.getWidth()*escalaX), (int)(tamanyoInicial.getHeight()*escalaY) ) );
                            c.setLocation( (int) (tamanyoInicial.getX()*escalaX), (int)(tamanyoInicial.getY()*escalaY) );
                        }
                    }
                }
            }
        });
        V.getContentPane().add( V.panelPrincipal, BorderLayout.CENTER );  // El panel ocupa siempre toda la ventana y se reescala con ella
        V.setVisible( true );
        while(true){
            V.o.incRotacion(0.01);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    class hilo implements Runnable{

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            while(cont< Gestion.g.arrayCircuito.get(0).getVueltas() + 1) {
                vueltas.setText((Gestion.g.arrayCircuito.get(Gestion.g.contCircuito).getVueltas() - cont) + "/" + Gestion.g.arrayCircuito.get(Gestion.g.contCircuito).getVueltas());
                cont++;
                Gestion.g.arrayTiempoVuelta.clear();
                Gestion.g.arrayTiempoVueltaSoloInicial.clear();
                //TODO posicion circuito
                /*s.simulacionVueltas(g.arrayCircuito, 0, g.arrayCoche, g.arrayTiempoVuelta, g.arrayTiempoVueltaSoloInicial, g.posPiloto, false);
                s.comprobacionDiferenciasArray(g.arrayCoche,g.arrayDiferenciaTiempo);
                g.ordenarPorTiempoTotal(g.arrayTiempoVueltaSoloInicial, g.arrayTiempoVuelta,g.arrayCoche, g.arrayDiferenciaTiempo);
                g.reordenarIndices(g.arrayTiempoVuelta);
                //g.stringArrayOrdenado(g.arrayTiempoVueltaSoloInicial,g.arrayTiempoVuelta,g.posPiloto);
                g.arrayTiempoVueltaSoloCopia.clear();
                g.copiarArray(g.arrayTiempoVueltaSoloInicial,g.arrayTiempoVueltaSoloCopia);
                g.arrayTiempoVuelta.clear();*/
                Simulacion.s.simulacionVueltas(Gestion.g.arrayCircuito,Gestion.g.contCircuito,Gestion.g.arrayCoche,Gestion.g.arrayTiempoVuelta, Gestion.g.arrayTiempoVueltaSoloInicial, Gestion.g.posPiloto, true);
                Simulacion.s.comprobacionDiferenciasArray(Gestion.g.arrayCoche,Gestion.g.arrayDiferenciaTiempo);
                Gestion.g.arrayDiferenciaTiempoVuelta.clear();
                Gestion.g.copiarArray(Gestion.g.arrayDiferenciaTiempo,Gestion.g.arrayDiferenciaTiempoVuelta);
                Gestion.g.ordenarPorTiempoTotal(Gestion.g.arrayTiempoVueltaSoloInicial,Gestion.g.arrayTiempoVuelta,Gestion.g.arrayCoche, Gestion.g.arrayDiferenciaTiempoVuelta);
                Gestion.g.reordenarIndices(Gestion.g.arrayTiempoVuelta);
                //g.stringArrayOrdenado(g.arrayTiempoVueltaSoloInicial,g.arrayTiempoVuelta,g.posPiloto);
                //s.calcularDiferencia(g.arrayTiempoVueltaSoloInicial,g.arrayTiempoVueltaSoloCopia,g.arrayDiferenciaTiempoVuelta);
                listModelVuelta.removeAllElements();
                listModelDiferenciaVueltas.removeAllElements();
                modeloJlist(Gestion.g.arrayTiempoVuelta, listModelVuelta);
                //modeloJlist(g.arrayDiferenciaTiempoVuelta,listModelDiferenciaVueltas);
                clasificacionVuelta.setModel(listModelVuelta);
                clasificacionVueltaDiferencia.setModel(listModelDiferenciaVueltas);
                Simulacion.s.gestionNeumaticos(Gestion.g.arrayCoche);
                //TODO
                progressBarUR.setValue((int)Gestion.g.arrayCoche.get(seleccion).getNeumaticos());
                progressBarUL.setValue((int)Gestion.g.arrayCoche.get(seleccion).getNeumaticos());
                progressBarDR.setValue((int)Gestion.g.arrayCoche.get(seleccion).getNeumaticos());
                progressBarDL.setValue((int)Gestion.g.arrayCoche.get(seleccion).getNeumaticos());
                Simulacion.s.paradaBoxesIA(Gestion.g.arrayCircuito, Gestion.g.arrayCoche, Gestion.g.arrayTiempoVuelta, Gestion.g.arrayTiempoVueltaSoloInicial, Gestion.g.posPiloto);
                //g.recopilarInformacion(g.informacionTabla);
                updateModel();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Gestion.g.mejoraIAExponencial(Gestion.g.arrayCoche, 1.08);
            Gestion.g.contCircuito++;
        }
    }
    class hiloRotacion implements Runnable{

        @Override
        public void run() {
            while(true){
                o.incRotacion(0.01);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
        }
    }
}}