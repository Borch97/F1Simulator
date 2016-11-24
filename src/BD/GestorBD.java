package BD;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;



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
    
    
    public ArrayList<Circuito> cargarDatosCircuitos()
    {
    
    }
    
    //AÑADIR METODOS DE USO
    public ArrayList<Coche> cargarDatosCoches()
    {
    	String q = "select * from Coches";
    	
    	ResultSet resultado = consultar( q );
    
    	ArrayList<Coche> alo = new ArrayList<>();
    	
    	try
    	{ 		
    		while( resultado.next() )
	    	{
    			//cada campo de la tabla de la BD
	    		String nom = resultado.getString("Nombre");
	    		int t = resultado.getInt("Tiempo");
	    		int n = resultado.getInt("Nivel");
	    		
	    		alo.add( new Coche(nom,t,n));
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
    public void guardarDatosCoche ( String pNombre , int pTiempo , int pNivel )
    {
    	try
    	{
	    	String q = "select Nombre,Tiempo,Nivel from Puntuacion where Nombre = '" + pNombre + "' AND Nivel = " + pNivel;
	    	
	    	ResultSet resultado = consultar( q );
	    	
	    	//insertar el coche porque es nuevo
	    	if( resultado.next() == false )
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
		    		
		    		if ( pTiempo < t )
		    		{
		    			System.out.println("POR AQUI");
		    			
		    			String upd = "UPDATE Puntuacion SET Tiempo = " + pTiempo 
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
    }  
    
}