package ejemplo1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class ConexionConDataSource {
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/ciclismo";
	final static String USR = "root";
	final static String PWD = "1234";

	public static void main(String[] args) {
		Connection con = null;
		// Creamos datasource y configuramos sus parámetros.
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(URL);
		ds.setUsername(USR);
		ds.setPassword(PWD);
		// Realizamos la conexión
		try {
			con = ds.getConnection();
			System.out.println("Conectado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerramos la conexión
			try {
				if (con != null && !con.isClosed())
					con.close();
				System.out.println("Desconectado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
