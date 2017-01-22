package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import datos.Gestion;
import datos.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTable;

public class VentanaMenu extends JFrame{

	private JFrame frame;
	private JTable table;
	Usuario u = new Usuario("Borja", 2000000);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMenu.class.getResource("/pictures/fc3b3rmula-1.jpg")));
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setResizable(false);
		
		JButton btnIrACarrera = new JButton("Ir a carrera");
		btnIrACarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana v = new Ventana();
				v.setVisible(true);
			}
		});
		btnIrACarrera.setBounds(299, 227, 125, 23);
		frame.getContentPane().add(btnIrACarrera);
		//TODO
		Gestion.g.arrayUsuario.add(u);
		JLabel lblDinero = new JLabel("DINERO: " + Integer.toString(Gestion.g.arrayUsuario.get(Gestion.g.obtenerPosicionUsuario()).getDinero()));
		lblDinero.setBounds(105, 31, 209, 14);
		frame.getContentPane().add(lblDinero);
		
		table = new JTable();
		table.setBounds(41, 89, 154, 146);
		frame.getContentPane().add(table);
	}


}
