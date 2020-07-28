package ejemplo1_jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class ScrollResultSet {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));// Ruta para conectar con SQL
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");

			// Obtener el ciclista mas mayor, el ciclista mas joven
			// El tercer ciclista mas joven, el segundo ciclista mas joven
			sql = "select nombre, dorsal from ciclista order by nacimiento desc";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();

			// El ciclista mas viejo
			rs.last();
			System.out.println("El ciclista mayor: " + rs.getString(1));

			// El ciclista mas joven
			rs.first();
			System.out.println("El ciclista mas joven: " + rs.getString(1));

			// El tercer ciclista mas joven
			rs.absolute(3);
			System.out.println("El tercer ciclista mas joven: " + rs.getString(1));

			// El segundo ciclista mas joven
			rs.previous();
			System.out.println("El segundo ciclista mas joven: " + rs.getString(1));

			// El segundo ciclista mas viejo
			rs.absolute(-2);
			System.out.println("El segundo ciclista mas viejo: " + rs.getString(1));

			// Sacar todos los registros de ciclista
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println("El ciclista: " + rs.getString(1));
				
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
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
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
