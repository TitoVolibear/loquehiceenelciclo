package ejercicios;

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

public class Ejer2_2_Transaction {
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

			autocommitActual = con.getAutoCommit();
			con.setAutoCommit(false);

			// transaccion insert
			pstmt = con.prepareStatement("insert into representante_ciclista values (?,?)");
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Juan Gracia");
			pstmt.executeUpdate();
			System.out.println("Insertado el representante");

			pstmt = con.prepareStatement("insert into ciclista values (?,?,?,?,?)");
			pstmt.setInt(1, 101);
			pstmt.setString(2, "ciclista_rep");
			pstmt.setString(3, "TVM");
			pstmt.setDate(4, null);
			pstmt.setInt(5, 1);
			pstmt.executeUpdate();
			System.out.println("Insertado el ciclista");

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
