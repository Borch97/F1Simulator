package GUI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import datos.Gestion;
import logica.Simulacion;

import java.awt.event.*;

public class VentanaUsuario extends JFrame{



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario window = new VentanaUsuario();
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
	public VentanaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			
				int r = JOptionPane.showConfirmDialog(getParent(), "¿Desea salir?");
			
				if ( r == JOptionPane.YES_OPTION )
				{
					System.exit(0);
				}
			}
		});
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuario.class.getResource("/pictures/fc3b3rmula-1.jpg")));
		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Nuevo Usuario");
		btnNewButton.addActionListener(arg0 -> {
            String m = JOptionPane.showInputDialog("Introduzca el nombre del nuevo usuario");
            while(m.length()<4) {
                JOptionPane.showMessageDialog(getParent(),"El nombre de usuario tiene que tener al menos 4 caracteres","Inane warning",JOptionPane.WARNING_MESSAGE);
                m = JOptionPane.showInputDialog("Introduzca el nombre del nuevo usuario");
            }
            Gestion.g.variableUsuario = m;
            Gestion.g.creacionPartidaNueva();
            Simulacion.s.simulacionVueltas(Gestion.g.arrayCircuito,0,Gestion.g.arrayCoche,Gestion.g.arrayTiempoVuelta,Gestion.g.arrayTiempoVueltaSoloInicial,Gestion.g.posPiloto, true);
            /*VentanaMenu vm = new VentanaMenu();
            vm.setVisible(true);*/
            VentanaMenu v = new VentanaMenu();
            v.setVisible(true);
            //getParent().setVisible(false);

        });
		btnNewButton.setBounds(159, 64, 130, 23);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
			}
		});
		btnNewButton_1.setBounds(159, 118, 130, 23);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int r = JOptionPane.showConfirmDialog(getParent(), "¿Desea salir?");
				
				if ( r == JOptionPane.YES_OPTION )
				{
					System.exit(0);
				}
			
			}
		});
		btnSalir.setBounds(159, 172, 130, 23);
		this.getContentPane().add(btnSalir);
		
		Panelimagen panel = new Panelimagen("/pictures/usu.jpg");
		panel.setBounds(0, 0, 444, 271);
		this.getContentPane().add(panel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		
		this.setLocation( (screenSize.width - windowSize.width)/2 , (screenSize.height - windowSize.height)/2 );
		
	}
	
	
}
