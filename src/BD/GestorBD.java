package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;

import javax.swing.JOptionPane;

import datos.Circuito;
import datos.Coche;
import datos.Usuario;

public class GestorBD {

	private Connection conexion;
	private Statement sentencia;
	private String ruta = "Formula1.sqlite";

	private static GestorBD mGestorBD;

	public static GestorBD getInstance() {
		if (mGestorBD == null) {
			mGestorBD = new GestorBD();
		}
		return mGestorBD;
	}

	private GestorBD() {

	}

	/**
	 * Metodo mediante el cual nos conectamos a la BD
	 */
	private void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
			sentencia = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Estado:" + e.getSQLState());
		}
	}

	/**
	 * Metodo mediante el cual nos desconectamos de la BD
	 */

	private void desconectar() {
		try {
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo al que hay que llamar para insertar datos en la BD
	 * 
	 * @param pSql
	 * @return
	 */
	private boolean insertar(String pSql) {
		boolean valor = true;
		conectar();
		try {
			sentencia.executeUpdate(pSql);
		} catch (SQLException e) {
			valor = false;
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			desconectar();
		}
		return valor;
	}

	private ResultSet consultar(String pSql) {
		conectar();
		ResultSet resultado = null;
		try {
			resultado = sentencia.executeQuery(pSql);
		} catch (SQLException e) {
			System.out.println("Mensaje:" + e.getMessage());
			System.out.println("Estado:" + e.getSQLState());
			System.out.println("Codigo del error:" + e.getErrorCode());

			JOptionPane.showMessageDialog(null, "" + e.getMessage());
		}

		return resultado;
	}

	/**
	 * Metodo con el que cargamos los datos de los circuitos de la BD
	 * 
	 * @return
	 */
	public ArrayList<Circuito> cargarDatosCircuitos() {
		String c = "select * from Circuito";

		ResultSet resultado = consultar(c);

		ArrayList<Circuito> circ = new ArrayList<>();

		try {
			cargarDatosCircuitosREC(circ, resultado);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			desconectar();
		}

		return circ;
	}

	/**
	 * Metodo recursivo para cargar los datos del los circuitos de la BD
	 * 
	 * @param pCircuitos
	 * @param pResultado
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<Circuito> cargarDatosCircuitosREC(ArrayList<Circuito> pCircuitos, ResultSet pResultado)
			throws SQLException {
		// CB
		if (!pResultado.next()) {
			return pCircuitos;
		}
		// CR
		else {
			// cada campo de la tabla de la BD
			String nom = pResultado.getString("nom_circuito");
			String pais = pResultado.getString("pais");
			int vuel = pResultado.getInt("num_vueltas");
			double lluv = pResultado.getDouble("pro_lluvia");
			String foto = pResultado.getString("foto_circ");
			int tini = pResultado.getInt("rango_tinicial");
			int tfin = pResultado.getInt("rango_tfinal");
			int pos = pResultado.getInt("posicionCircuito");

			pCircuitos.add(new Circuito(nom, pais, vuel, lluv, foto, tini, tfin, pos));

			cargarDatosCircuitosREC(pCircuitos, pResultado);

			return pCircuitos;
		}
	}

	/**
	 * Metodo para obtener la informacion de los circuitos
	 * 
	 * @return
	 */
	public ArrayList<Circuito> obtenerInfoCircuito() {

		String c = "select * from Circuito ";
		Circuito circuito = null;
		ResultSet resultado = consultar(c);

		ArrayList<Circuito> circuitos = new ArrayList<Circuito>();

		try {
			while (resultado.next()) {
				// cada campo de la tabla de la BD
				String nom = resultado.getString("nom_circuito");
				String pais = resultado.getString("pais");
				int vuel = resultado.getInt("num_vueltas");
				double lluv = resultado.getDouble("pro_lluvia");
				String foto = resultado.getString("foto_circ");
				int tini = resultado.getInt("rango_tinicial");
				int tfin = resultado.getInt("rango_tfinal");
				int pos = resultado.getInt("posicionCircuito");

				circuito = new Circuito(nom, pais, vuel, lluv, foto, tini, tfin, pos);

				circuitos.add(circuito);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			desconectar();
		}

		return circuitos;
	}

	/**
	 * Obtener la informacion de los pilotos de la BD
	 * 
	 * @return
	 */
	public ArrayList<String> obtenerInfoPilotos() {

		String c = "select nom_piloto from Pilotos";

		ResultSet resultado = consultar(c);

		ArrayList<String> pilotos = new ArrayList<String>();

		try {
			while (resultado.next()) {
				// cada campo de la tabla de la BD
				String nom = resultado.getString("nom_piloto");
				pilotos.add(nom);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			desconectar();
		}

		return pilotos;
	}

	/**
	 * Obtener la informacion de las escuderias de la BD
	 * 
	 * @return
	 */

	public ArrayList<String> obtenerInfoEscuderias() {

		String c = "select escuderia from Escuderias";

		ResultSet resultado = consultar(c);

		ArrayList<String> escuderias = new ArrayList<String>();

		try {
			while (resultado.next()) {
				// cada campo de la tabla de la BD
				String esc = resultado.getString("escuderia");
				escuderias.add(esc);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			desconectar();
		}

		return escuderias;
	}

	/**
	 * Obtener la informacion del usuario de la BD
	 * 
	 * @return
	 */
	public ArrayList<Usuario> obtenerInfoUsuario() {

		String c = "select*from Usuario";
		Usuario usuario = null;

		ResultSet resultado = consultar(c);

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			while (resultado.next()) {
				// cada campo de la tabla de la BD
				String nom_us = resultado.getString("nom_usuario");
				String nom = resultado.getString("nom_piloto");
				int din = resultado.getInt("dinero");
				usuario = new Usuario(nom, din, nom_us);

				usuarios.add(usuario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			desconectar();
		}

		return usuarios;
	}

	/**
	 * Obtener la probabilidad de lluvia de los circuitos de la BD
	 * 
	 * @param nomcircuito
	 * @return
	 */
	public double obtenerProbLluviaCircuito(String nomcircuito) {

		String c = "select prob_lluvia from Circuito where nom_circuito = '" + nomcircuito + "'";

		ResultSet resultado = consultar(c);

		double lluvia = 0.0;

		try {
			if (resultado.next()) {
				// cada campo de la tabla de la BD
				lluvia = resultado.getDouble("prob_lluvia");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			desconectar();
		}

		return lluvia;
	}

	/**
	 * Visualizar los datos del circuito por pantalla
	 */
	public void visualizarDatosCircuitos() {
		ArrayList<Circuito> alo = cargarDatosCircuitos();

		System.out.println(alo);

	}

	/**
	 * Guardar los datos de los coches en la BD
	 * 
	 * @param pCoche
	 */
	public void guardarDatosCoche(Coche pCoche) {

		String pilo = pCoche.getNom_piloto();
		String abre = pCoche.getAbreviado();
		String escu = pCoche.getEscuderia();
		double velo = pCoche.getVelocidad();
		double acel = pCoche.getAceleracion();
		double aero = pCoche.getAerodinamica();
		double rotu = pCoche.getProb_rotura();
		double neum = pCoche.getNeumaticos();
		String usua = pCoche.getNom_usuario();
		int punt = pCoche.getPuntos();

		try {
			// Poner como los datos del add de arriba
			String q = "select nom_piloto,abreviado,escuderia, velocidad, aceleracion, aerodinamica,"
					+ "prob_rotura,neumaticos,nom_usuario,puntos from Coche where nom_piloto = '" + pilo + "'"
					+ " and nom_usuario = '" + usua + "'";

			ResultSet resultado = consultar(q);

			// insertar el coche porque es nuevo
			if (resultado.next() == false) {
				String ins = "INSERT INTO Coche ('nom_piloto','abreviado','escuderia',"
						+ "'velocidad','aceleracion','aerodinamica',"
						+ "'prob_rotura','neumaticos','nom_usuario', 'puntos') VALUES ('" + pilo + "','" + abre + "','"
						+ escu + "'," + velo + "," + acel + "," + aero + "," + rotu + "," + neum + ",'" + usua + "',"
						+ punt + ")";
				insertar(ins);
			} else {
				while (resultado.next()) {
					String pilo1 = resultado.getString("nom_piloto");
					String abre1 = resultado.getString("abreviado");
					String escu1 = resultado.getString("escuderia");
					double velo1 = resultado.getDouble("velocidad");

					double acel1 = resultado.getDouble("aceleracion");
					double aero1 = resultado.getDouble("aerodinamica");

					double rotu1 = resultado.getDouble("prob_rotura");
					double neum1 = resultado.getDouble("neumaticos");
					String usua1 = resultado.getString("nom_usuario");
					int punt1 = resultado.getInt("puntos");

					if (velo < velo1) {

						String upd = "UPDATE coche SET aerodinamica = " + velo1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}
					if (acel < acel1) {

						String upd = "UPDATE coche SET aerodinamica = " + acel1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}

					if (aero < aero1) {

						String upd = "UPDATE coche SET aerodinamica = " + aero1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}

					if (punt < punt1) {

						String upd = "UPDATE coche SET puntos = " + punt1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}

				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Guardar los datos del usuario en la BD
	 * 
	 * @param pUsuario
	 */
	public void guardarDatosUsuario(Usuario pUsuario) {

		String pilo = pUsuario.getNom_piloto();
		String abre = pUsuario.getAbreviado();
		String escu = pUsuario.getEscuderia();
		double velo = pUsuario.getVelocidad();
		double acel = pUsuario.getAceleracion();
		double aero = pUsuario.getAerodinamica();
		double rotu = pUsuario.getProb_rotura();
		double neum = pUsuario.getNeumaticos();
		String usua = pUsuario.getNom_usuario();
		int din = pUsuario.getDinero();

		try {
			// Poner como los datos del add de arriba
			String q = "select nom_piloto,abreviado,escuderia, velocidad, aceleracion, aerodinamica,"
					+ "prob_rotura,neumaticos,nom_usuario,dinero from Usuario where nom_piloto = '" + pilo + "'"
					+ " and nom_usuario = '" + usua + "'";

			ResultSet resultado = consultar(q);

			// insertar el coche porque es nuevo
			if (resultado.next() == false) {
				String ins = "INSERT INTO Usuario ('nom_piloto','abreviado','escuderia',"
						+ "'velocidad','aceleracion','aerodinamica',"
						+ "'prob_rotura','neumaticos','nom_usuario','dinero') VALUES ('" + pilo + "','" + abre + "','"
						+ escu + "'," + velo + "," + acel + "," + aero + "," + rotu + "," + neum + ",'" + usua + "',"
						+ din + ")";
				insertar(ins);
			} else {
				while (resultado.next()) {
					String pilo1 = resultado.getString("nom_piloto");
					String abre1 = resultado.getString("abreviado");
					String escu1 = resultado.getString("escuderia");
					double velo1 = resultado.getDouble("velocidad");

					double acel1 = resultado.getDouble("aceleracion");
					double aero1 = resultado.getDouble("aerodinamica");

					double rotu1 = resultado.getDouble("prob_rotura");
					double neum1 = resultado.getDouble("neumaticos");
					String usua1 = resultado.getString("nom_usuario");
					int din1 = resultado.getInt("dinero");
					/**
					 * String nom = resultado.getString("Nombre"); int t =
					 * resultado.getInt("Tiempo"); int n =
					 * resultado.getInt("Nivel");
					 */
					if (velo < velo1) {

						String upd = "UPDATE usuario SET velocidad = " + velo1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}

					if (acel < acel1) {

						String upd = "UPDATE usuario SET aceleracion = " + acel1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}

					if (aero < aero1) {

						String upd = "UPDATE usuario SET aerodinamica = " + aero1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}

					if (din < din1 || din > din1) {

						String upd = "UPDATE usuario SET puntos = " + din1 + " WHERE nom_usuario '" + usua
								+ "' AND nom_piloto = '" + pilo + "'";

						sentencia.executeUpdate(upd);
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}

















