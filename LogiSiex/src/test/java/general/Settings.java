package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.testng.annotations.BeforeSuite;

public class Settings {
	public static Connection conexion;
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		try {
			String connectionUrl = Variables.leerPropiedad("sqlUrl");
			//String connectionUrl = "jdbc:sqlserver://192.168.100.13\\Test;database=LOGICORBA_PICHINCHA;user=usrGestorParametros;password=gestor;encrypt=true;trustServerCertificate=true;loginTimeout=30;";
			conexion = DriverManager.getConnection(connectionUrl);
			//System.out.println("Conectado.");
		} 
		catch (SQLException ex) 
		{
			System.out.println("Error: "+ex.getMessage());
		}

	}
}
