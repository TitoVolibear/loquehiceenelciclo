package ejemplo1_jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class ConexionFicheroPropiedades {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			// Crear conexion DataSource
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			// Creamos la sentencia sql que queremos lanzar
			stmt = con.createStatement();
			// Crear una tabla
			String sql = "CREATE TABLE if not exists nacionalidad (id int(10), nombre varchar(50) NOT NULL, pais varchar(50), PRIMARY KEY (id))";
			// Como es una modificacion sobre la BD se utiliza executeUpdate
			stmt.executeUpdate(sql);

			// Insertar uan fila en la tabla
			// sql = "INSERT INTO nacionalidad VALUES(1, 'española', 'España')";
			stmt.executeUpdate(sql);
			System.out.println("Inserción realizada");

			// Consulta-Recuperacion de informacion de la base de datos
			sql = "SELECT count(*) FROM equipo";
			rs = stmt.executeQuery(sql);
			rs.first();
			System.out.println("Numero de equipos: " + rs.getInt(1));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
