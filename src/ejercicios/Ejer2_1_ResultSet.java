package ejercicios;

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

public class Ejer2_1_ResultSet {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
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

			// a. Actualiza el valor de los maillot de tipo1 incrementa el valor del
			// premio en 100 €
			// sql = "select * from maillot where tipo = ?";
			// pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			// pstmt.setString(1, "tipo1");
			// rs = pstmt.executeQuery();
			// rs.first();
			// rs.updateInt(4, rs.getInt(4) + 100);
			// rs.updateRow();

			// b. Muestra el valor del último registro de la tabla ETAPA
			// sql = "select * from etapa";
			// pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			// rs = pstmt.executeQuery();
			// rs.last();
			// System.out.println(rs.getInt(1) + " - " + rs.getInt(2) + " - " +
			// rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getInt(5));

			// c. Cuáles son las ciudad de salida de la etapa que se encuentra en el
			// registro 2
			// sql = "select * from etapa";
			// pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			// rs = pstmt.executeQuery();
			// rs.absolute(2);
			// System.out.println(rs.getString(3));

			// d. Modifica su valor por una ciudad de salida que introduzca el usuario.
			// System.out.println("Introduce una ciudad: ");
			// String ciudad = tec.next();
			// rs.updateString(3, ciudad);
			// rs.updateRow();

			// ----------AMPLIACION----------
			// Actualiza los puertos de altura mayor a 1500m, su categoria a X
			sql = "select * from puerto where altura > 1500";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rs.updateString(3, "X");
				rs.updateRow();
			}

			// Inserta un nuevo maillot codigo=COD2, color=color2, premio=200
			// sql = "select * from maillot";
			// pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			// rs = pstmt.executeQuery();
			// rs.moveToInsertRow();
			// rs.updateString(1, "CD2");
			// rs.updateString(2, "tipo2");
			// rs.updateString(3, "Color2");
			// rs.updateInt(4, 200);
			// rs.insertRow();

			// Borra los maillot que no han sido llevados nunca

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
