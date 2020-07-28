package ejemplo1_jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Ejemplo_InsertPreparedStatement {
	// Realizar inserciones de forma consecutiva pidiendo valores al usuario en la
	// tabla nacionalidades.
	// Si introduce como id = 0, ya no pide mas valores
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		Integer id = 0;
		String nombre = null;
		String pais = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));// Ruta para conectar con SQL
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");

			// Insertar en la tabla nacionalidad
			pstmt = con.prepareStatement("INSERT INTO nacionalidad VALUES(?, ?, ?);");

			// Crear un bucle
			// -Condicion buclo <>0
			// -Pedir los valores
			// -Asignarlos a los parametros(?) del insert
			// -Ejecutar la sentencia
			do {
				System.out.println("ID: ");
				id = tec.nextInt();
				if (id == 0) {
					nombre = null;
					pais = null;
				} else {
					System.out.println("Nombre: ");
					nombre = tec.next();
					System.out.println("Pais: ");
					pais = tec.next();

					pstmt.setInt(1, id);
					pstmt.setString(2, nombre);
					pstmt.setString(3, pais);
					pstmt.executeUpdate();
				}
			} while (id != 0);
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
