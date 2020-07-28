package ejemplo1_jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class EjemploPreparedStatement {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Leer el dato que me pide el usuario
		System.out.println("Categoria del puerto: ");
		String categoria = tec.nextLine();
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));// Ruta para conectar con SQL
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			// Obtener el nombre de los ciclistas que han ganado puertos de la categoria que
			// indica el usuario
			pstmt = con.prepareStatement("SELECT nombre FROM ciclista NATURAL JOIN puerto WHERE categoria = ?");

			// Le asignamos valor al ? con el valor que ha introducido el usuario
			pstmt.setString(1, categoria);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Ciclista: " + rs.getString(1));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerramos el ResultSet
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
					System.out.println("ResultSet cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
