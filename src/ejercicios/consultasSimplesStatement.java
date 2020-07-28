package ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class consultasSimplesStatement {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");

			stmt = con.createStatement();
			String sql;
			// a. Dorsal, nombre y equipo de todos los ciclistas. <-- Funciona
			// sql = "SELECT dorsal, nombre, nomeq FROM ciclista";
			// rs = stmt.executeQuery(sql);
			// while (rs.next()) {
			// Integer dorsal = rs.getInt(1);
			// String nombre = rs.getString(2);
			// String nomeq = rs.getString(3);
			// System.out.println("Dorsal: " + dorsal + " - Nombre: " + nombre + " -
			// Nom.Eq.: " + nomeq);
			// }

			// b. Dorsal, nombre y director de todos los ciclistas. <-- Funciona
			// sql = "SELECT dorsal, nombre, director FROM ciclista NATURAL JOIN equipo";
			// rs = stmt.executeQuery(sql);
			// while (rs.next()) {
			// Integer dorsal = rs.getInt(1);
			// String nombre = rs.getString(2);
			// String director = rs.getString(3);
			// System.out.println("Dorsal: " + dorsal + " - Nombre: " + nombre + " -
			// Director: " + director);
			// }

			// c. Dorsal, nombre y director de los ciclistas del equipo “ONCE” <-- Funciona
			// sql = "SELECT dorsal, nombre, director FROM ciclista NATURAL JOIN equipo
			// WHERE nomeq = 'ONCE';";
			// rs = stmt.executeQuery(sql);
			// while (rs.next()) {
			// Integer dorsal = rs.getInt(1);
			// String nombre = rs.getString(2);
			// String director = rs.getString(3);
			// System.out.println("Dorsal: " + dorsal + " - Nombre: " + nombre + " -
			// Director: " + director);
			// }

			// d. Dorsal, nombre y equipo de los ciclistas del equipo cuyo nombre indique
			// el usuario.
			// System.out.println("Introduce nombre de equipo: ");
			// String nom = tec.nextLine();
			//
			// sql = "SELECT dorsal, nombre, nomeq FROM ciclista WHERE nomeq = '" + nom
			// +"';";
			// rs = stmt.executeQuery(sql);
			// while (rs.next()) {
			// Integer dorsal = rs.getInt(1);
			// String nombre = rs.getString(2);
			// String nomeq = rs.getString(3);
			// System.out.println("Dorsal: " + dorsal + " - Nombre: " + nombre + " -
			// Nom.Eq.: " + nomeq);
			// }

			// e. Dorsal, nombre y equipo de los ciclistas del equipo cuyo nombre indique el
			// usuario y cuyo nombre contenga el texto que indique el usuario.
			System.out.println("Introduce nombre de equipo: ");
			String nombreEq = tec.next();
			System.out.println("Introduce nombre + apellido de ciclista:");
			String nombreCi = tec.nextLine();
			String apellidoCi = tec.next();

			sql = "SELECT dorsal, nombre, nomeq FROM ciclista WHERE nomeq = '" + nombreEq + "' AND nombre = '"
					+ nombreCi + " " + apellidoCi + "';";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer dorsal = rs.getInt(1);
				String nombre = rs.getString(2);
				String nomeq = rs.getString(3);
				System.out.println("Dorsal: " + dorsal + " - Nombre: " + nombre + " - Nom.Eq.: " + nomeq);
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
