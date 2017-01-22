package GUI;

import java.awt.EventQueue;

import javax.swing.*;

import datos.Gestion;
import datos.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaMenu extends JFrame{

	private JList table;
	Usuario u = new Usuario("Borja", 2000000);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		
		JButton btnIrACarrera = new JButton("Ir a carrera");
		btnIrACarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana v = new Ventana();
				v.setVisible(true);
			}
		});
		btnIrACarrera.setBounds(550, 400, 125, 23);
		this.getContentPane().add(btnIrACarrera);
		//TODO
		Gestion.g.arrayUsuario.add(u);
		JLabel lblDinero = new JLabel("DINERO: " + Integer.toString(Gestion.g.arrayUsuario.get(Gestion.g.obtenerPosicionUsuario()).getDinero()));
		lblDinero.setBounds(330, 31, 209, 14);
		this.getContentPane().add(lblDinero);
		Gestion.g.arrayListToArray();
		table = new JList(Gestion.g.informacionClasificaion);
        JScrollPane listScroller = new JScrollPane(table);
        listScroller.setOpaque(false);
		listScroller.setBounds(41, 89, 200, 300);

		this.getContentPane().add(listScroller);
	}


}
