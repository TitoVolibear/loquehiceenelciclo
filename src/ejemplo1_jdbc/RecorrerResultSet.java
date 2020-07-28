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

public class RecorrerResultSet {
	// Listar las etapas(NUMERO DE ETAPA, CIUDAD DE SALIDA)
	// que ha ganado el ciclista Pedro Delgado
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

			stmt = con.createStatement();
			String sql = "SELECT netapa, salida FROM ciclista NATURAL JOIN etapa WHERE nombre = 'Pedro Delgado';";

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer netapa = rs.getInt(1);
				String salida = rs.getString(2);
				System.out.println("Nº Etapa: " + netapa + " - Salida: " + salida);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerramos el statement
			try {
				if (stmt != null && !stmt.isClosed())
					stmt.close();
				System.out.println("Desconectado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// Cerramos el ResultSet
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
					System.out.println("ResultSet cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//
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
