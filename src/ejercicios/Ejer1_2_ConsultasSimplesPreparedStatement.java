package ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Ejer1_2_ConsultasSimplesPreparedStatement {
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
			// a. Inserta los valores de un nuevo maillot que introduzca el usuario.
			// sql = "insert into maillot values(? ,? ,? ,?)";
			// pstmt = con.prepareStatement(sql);
			// System.out.println("Introduce codigo: ");
			// String codigo = tec.next();
			// System.out.println("Introduce tipo: ");
			// String tipo = tec.next();
			// System.out.println("Introduce color: ");
			// String color = tec.next();
			// System.out.println("Introduce premio: ");
			// int premio = tec.nextInt();
			// pstmt.setString(1, codigo);
			// pstmt.setString(2, tipo);
			// pstmt.setString(3, color);
			// pstmt.setInt(4, premio);
			// pstmt.executeUpdate();

			// b. Consulta en primer lugar los ciclistas del equipo Banesto de más de 20
			// años
			// sql = "select nombre from ciclista where nomeq = \'Banesto\' and
			// year(CURDATE()) - year(nacimiento) > 20";
			// pstmt = con.prepareStatement(sql);
			// rs = pstmt.executeQuery();
			// while (rs.next()) {
			// System.out.println("-" + rs.getString(1));
			// }

			// c. Consulta en segundo lugar los ciclista del equipo ONCE de más de 25
			// años.
			// sql = "select nombre from ciclista where nomeq = \'ONCE\' and year(CURDATE())
			// - year(nacimiento) > 25";
			// pstmt = con.prepareStatement(sql);
			// rs = pstmt.executeQuery();
			// while (rs.next()) {
			// System.out.println("-" + rs.getString(1));
			// }

			// d. Actualizar(sumar) el premio del maillot AMARILLO en 100 €
			// sql = "update maillot set premio = premio + 100 where color = \"Amarillo\"";
			// pstmt = con.prepareStatement(sql);
			// pstmt.executeUpdate();

			// e. Actualizar(sumar) el premio del maillots del tipo que indique el usuario
			// en 50€
			// sql = "update maillot set premio = premio + 50 where color = ?";
			// pstmt = con.prepareStatement(sql);
			// System.out.println("Indica a que maillot sumarle premio: ");
			// String sumar = tec.next();
			// pstmt.setString(1, sumar);
			// pstmt.executeUpdate();

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
