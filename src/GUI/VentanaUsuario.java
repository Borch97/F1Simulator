package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaUsuario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario window = new VentanaUsuario();
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
	public VentanaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			
				int r = JOptionPane.showConfirmDialog(frame, "¿Desea salir?");
			
				if ( r == JOptionPane.YES_OPTION )
				{
					System.exit(0);
				}
			}
		});
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuario.class.getResource("/pictures/sun.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Nuevo Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton.setBounds(159, 64, 130, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
			}
		});
		btnNewButton_1.setBounds(159, 118, 130, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int r = JOptionPane.showConfirmDialog(frame, "¿Desea salir?");
				
				if ( r == JOptionPane.YES_OPTION )
				{
					System.exit(0);
				}
			
			}
		});
		btnSalir.setBounds(159, 172, 130, 23);
		frame.getContentPane().add(btnSalir);
		
		Panelimagen panel = new Panelimagen();
		panel.setBounds(0, 0, 444, 271);
		frame.getContentPane().add(panel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = frame.getSize();
		
		frame.setLocation( (screenSize.width - windowSize.width)/2 , (screenSize.height - windowSize.height)/2 );
		
	}
	
	public static void nuevoUsuario(){
		String m = JOptionPane.showInputDialog("Introduzca el nombre del nuevo usuario");
		//int e = Integer.parseInt(JOptionPane.showInputDialog("..."));
	}
}
