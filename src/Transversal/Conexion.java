package Transversal;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 */

/**
 * @author Alumno
 *
 */
public class Conexion {
	
	private final String URL="jdbc:mysql://localhost:3306/";
	private final String DB = "DBEJERCICIO1?serverTimezone=UTC";
	private final String USER="root";
	private final String PASSWORD="Adivinala1.";
	
	public Connection conexion = null;
	
	//@supresswarnings("finally")
	public Connection conectar(){
		
		try{
			
			//class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(URL + DB, USER, PASSWORD);
			if(conexion != null){
				System.out.println("Conexión exitosa");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				if(conexion != null){
					return conexion;
				} else {
					return null;
				}
			}catch(Exception e){
				return null;
			}
		}
	}

}
