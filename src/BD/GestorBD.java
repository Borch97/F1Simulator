package BD;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.Circuito;
import datos.Coche;



public class GestorBD{
	
	private Connection conexion;
	private Statement sentencia;
	private String ruta = "formula1.sqlite";
	
	private static GestorBD mGestorBD;
	
	public static GestorBD getInstance() 
	{
		if ( mGestorBD == null )
		{
			mGestorBD = new GestorBD();
		}
		return mGestorBD;
	}
	
	private GestorBD()
    {
       
    }
    
    private void conectar()
    {
    	try {
			Class.forName("org.sqlite.JDBC");
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {			
			conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);	
			sentencia = conexion.createStatement();		
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Estado:"+e.getSQLState());
		}	
	}    
    
    private void desconectar()
    {
    	try
        {    
             sentencia.close();  
             conexion.close();  
        }
        catch (Exception e)
        {                 
        	e.printStackTrace();  
        }  
    }
    
    private boolean insertar(String pSql)
    {
        boolean valor = true;
        conectar();
        try 
        {
            sentencia.executeUpdate(pSql);
        } 
        catch (SQLException e) 
        {
        	valor = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }      
        finally
        {  
            desconectar();
        }
        return valor;
    }
   
    private ResultSet consultar(String pSql)
    {
        conectar();
        ResultSet resultado = null;
        try 
        {
            resultado = sentencia.executeQuery(pSql);
        } 
        catch (SQLException e) 
        {
        	System.out.println("Mensaje:"+e.getMessage());
            System.out.println("Estado:"+e.getSQLState());
            System.out.println("Codigo del error:"+e.getErrorCode());
            
            JOptionPane.showMessageDialog(null, ""+e.getMessage());
        }
                    
        return resultado;
    }
    
    
   
    //AÑADIR METODOS DE USO
    public ArrayList<Circuito> cargarDatosCircuitos()
    {
    	String c = "select * from Circuito";
    	
    	ResultSet resultado = consultar( c );
    
    	ArrayList<Circuito> alo = new ArrayList<>();
    	
    	try
    	{ 		
    		while( resultado.next() )
	    	{
    			//cada campo de la tabla de la BD
	    		String nom = resultado.getString("Nombre");
	    		String pais = resultado.getString("pais");
	    		int vuel = resultado.getInt("numerovueltas");
	    		double lluv = resultado.getDouble("prob lluvia");
	    		// String foto
	    		long tini = resultado.getLong("rangoTiempoInicial");
	    		long tfin = resultado.getLong("rangoTiempoFinal");
	    		
	    		
	    		
	    		//alo.add( new Circuito(nom,pais,vuel,lluv,null,tini,tfin));
	    	}    		    			
    	}
    	catch( SQLException ex )
    	{
    		ex.printStackTrace();
    	}   	
    	finally
    	{
    		desconectar();
    	}
    	
    	return alo;
    }
    
    
    public void visualizarDatosCoches()
    {
    	ArrayList<Coche> alo = cargarDatosCoche();
    
    	System.out.println( alo );
    }
    
    
    public ArrayList<Coche> cargarDatosCoche()
    {
    	String q = "select * from Coche";
    	
    	ResultSet resultado = consultar( q );
    
    	ArrayList<Coche> alo = new ArrayList<>();
    	
    	try
    	{ 		
    		while( resultado.next() )
	    	{
    			//cada campo de la tabla de la BD
	    		String nom = resultado.getString("nom_piloto");
	    		String usu = resultado.getString("nom_usuario");
	    		String abr = resultado.getString("abreviado");
	    		String esc = resultado.getString("escuderia");
	    		double vel = resultado.getDouble("velocidad");
	    		double ace = resultado.getDouble("aceleracion");
	    		double aero = resultado.getDouble("aerodinamica");
	    		double rot = resultado.getDouble("rotura");
	    		
	    		//alo.add( new Coche(nom,abr,esc,vel,ace,aero,rot));
	    	}    		    			
    	}
    	catch( SQLException ex )
    	{
    		ex.printStackTrace();
    	}   	
    	finally
    	{
    		desconectar();
    	}
    	
    	return alo;
    }
    //enviar por parametros los datos de un coche
    public void guardarDatosCoche ( Coche pCoche )
    {
    	
    	String nom = pCoche.getNombre();
    	//int nive = pCoche.
    	
    	//try {
			//String q = "select nom_piloto,Tiempo,Nivel from Puntuacion where Nombre = '" + nom + "' AND Nivel = " + nivel;

			//ResultSet resultado = consultar( q );

			//insertar el coche porque es nuevo
	    	/*if( resultado.next() == false )
	    	{
	    		String ins = "INSERT INTO Puntuacion ('Nombre','Tiempo','Nivel') VALUES ('"+pNombre+"'," + pTiempo + "," + pNivel +")";    	
	    		insertar( ins );
	    	}
	    	else
	    	{
	    		while( resultado.next() )
		    	{
		    		String nom = resultado.getString("Nombre");
		    		int t = resultado.getInt("Tiempo");
		    		int n = resultado.getInt("Nivel");
		    		
		    		//if ( pTiempo < t )
		    		{
		    			System.out.println("POR AQUI");
		    			
		    			/*String upd = "UPDATE Puntuacion SET Tiempo = " + pTiempo
		    					+ " WHERE Nombre = '" + nom + "' AND Nivel = " + n;	
		    			
		    			sentencia.executeUpdate( upd );
		    		}
		    	}    	
	    	}
    	}
    	catch(SQLException ex )
    	{
    		ex.printStackTrace();
    	}
    }*/

	/*public ArrayList<Circuito> obtenerInfoCircuitos(){
				
		String c = "select * from Circuito";
    	Circuito circuito = null;
    	ResultSet resultado = consultar( c );
    	
    	ArrayList<Circuito> circuitos = new ArrayList<Circuito>();
    	
    	try
    	{ 		
    		while( resultado.next() )
	    	{
    			//cada campo de la tabla de la BD
	    		//String nom = resultado.getString("Nombre");
	    		String pais = resultado.getString("pais");
	    		int vuel = resultado.getInt("numerovueltas");
	    		double lluv = resultado.getDouble("prob lluvia");
	    		// String foto
	    		long tini = resultado.getLong("rangoTiempoInicial");
	    		long tfin = resultado.getLong("rangoTiempoFinal");
	    		
	    		//circuito = new Circuito(nombre,pais,vueltas,probll //........ )
	    				
	    		circuitos.add( circuito );
	    	}    		    			
    	}
    	catch( SQLException ex )
    	{
    		ex.printStackTrace();
    	}   	
    	finally
    	{
    		desconectar();
    	}
    		
			
		return circuitos;
	}  */

		}}


















