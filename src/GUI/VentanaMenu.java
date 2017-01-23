package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datos.Gestion;
import datos.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame{

	private JList table;
    private JTextArea jTextArea;
    private JScrollPane listScroller;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                VentanaMenu window = new VentanaMenu();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the application.
	 */
	public VentanaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMenu.class.getResource("/pictures/fc3b3rmula-1.jpg")));
		this.setBounds(100, 100, 720, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
        this.setResizable(false);


        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
		JButton btnIrACarrera = new JButton("Ir a carrera");
		btnIrACarrera.addActionListener(arg0 -> {
            dispose();
            Ventana v = new Ventana();
            v.setVisible(true);
        });
		btnIrACarrera.setBounds(550, 400, 125, 23);
		this.getContentPane().add(btnIrACarrera);
		//TODO
		JLabel lblDinero = new JLabel("DINERO: " + Integer.toString(Gestion.g.arrayUsuario.get(Gestion.g.obtenerPosicionUsuario()).getDinero()));
		lblDinero.setBounds(330, 31, 209, 14);
		this.getContentPane().add(lblDinero);
        //Gestion.g.copiarArrayCoche(Gestion.g.arrayCoche,Gestion.g.arrayCocheClasificacion);
		Gestion.g.arrayListToArray();
		table = new JList(Gestion.g.informacionClasificaion);
        table.addListSelectionListener(e -> {
            int pos = table.getSelectedIndex();
            if (pos != -1) {
                jTextArea.setText("Nombre: " + Gestion.g.arrayCoche.get(Gestion.g.buscarPosicion(Gestion.g.arrayCoche.get(table.getSelectedIndex()).getNom_piloto())).getNom_piloto() + "\n\nEscuderia: " + Gestion.g.arrayCoche.get(Gestion.g.buscarPosicion(Gestion.g.arrayCoche.get(table.getSelectedIndex()).getNom_piloto())).getEscuderia() + "\n\nPuntos: " + Gestion.g.arrayCoche.get(Gestion.g.buscarPosicion(Gestion.g.arrayCoche.get(table.getSelectedIndex()).getNom_piloto())).getPuntos()+
                "\n\nAceleracion: " + Gestion.g.arrayCoche.get(Gestion.g.buscarPosicion(Gestion.g.arrayCoche.get(table.getSelectedIndex()).getNom_piloto())).getAceleracion() + "\n\nAerodinamica: " + Gestion.g.arrayCoche.get(Gestion.g.buscarPosicion(Gestion.g.arrayCoche.get(table.getSelectedIndex()).getNom_piloto())).getAerodinamica() + "\n\nVelocidad: " + Gestion.g.arrayCoche.get(Gestion.g.buscarPosicion(Gestion.g.arrayCoche.get(table.getSelectedIndex()).getNom_piloto())).getVelocidad());
            }
        });
        table.setCellRenderer(new TransparentCellListRender());
        table.setOpaque(false);
        listScroller = new JScrollPane(table);
        listScroller.setOpaque(false);
        listScroller.getViewport().setOpaque(false);
        listScroller.setBorder(null);
		listScroller.setBounds(41, 89, 200, 300);
        jTextArea.setBounds(500,89,200,200);
        jTextArea.setOpaque(false);
        Panelimagen panel = new Panelimagen("/pictures/test10.jpg");
        panel.setBounds(0,0,720,480);
        this.getContentPane().add(jTextArea);
		this.getContentPane().add(listScroller);
        this.getContentPane().add(panel);
	}


    }



