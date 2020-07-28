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

public class Transaccion {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean autocommitActual = false;

		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));// Ruta para conectar con SQL
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");

			// Crea una transaccion que inserte dos equipos,
			// insertar los dos equipos o ninguno
			autocommitActual = con.getAutoCommit();
			con.setAutoCommit(false);

			// transaccion insert
			pstmt = con.prepareStatement("insert into equipo(nomeq,director) values (?,?)");
			pstmt.setString(1, "Equipo_e1");
			pstmt.setString(2, "director_d1");
			pstmt.executeUpdate();
			System.out.println("Inserto 1");

			pstmt.setString(1, "Equipo_e2");
			pstmt.setString(2, "director_d2");
			pstmt.executeUpdate();
			System.out.println("Inserto 2");

			// confirmacion commit
			con.commit();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// Deshacemos los cambios si falla la transaccion
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// Cerramos la conexión
			try {
				// Devolvemos al SGBD el estado del commit que tenia antes de la transaccion
				con.setAutoCommit(false);
				if (con != null && !con.isClosed())
					con.close();
				System.out.println("Desconectado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
