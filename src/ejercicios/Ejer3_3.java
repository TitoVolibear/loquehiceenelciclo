package ejercicios;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Ejer3_3 {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rsTablas = null;
		DatabaseMetaData dbmd = null;
		// PreparedStatement pstmt = null;
		// ResultSetMetaData rsMD = null;

		try {
			// Conexión -------------
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			dbmd = con.getMetaData();

			// a. Qué versión de driver tienes instalado
			String versionDriver = dbmd.getDriverVersion();
			System.out.println("Version de driver: " + versionDriver);

			// b. Qué sistema gestor de base de datos estás conectado
			String sgbd = dbmd.getDatabaseProductName();
			System.out.println("SGBD: " + sgbd);

			// c. Qué tablas y vistas tiene tu base de datos
			rsTablas = dbmd.getTables(null, null, null, new String[] { "VIEW", "TABLE" });
			while (rsTablas.next()) {
				System.out.println("Nombre: " + rsTablas.getString("TABLE_NAME") + " - Esquema: "
						+ rsTablas.getString("TABLE_SCHEM") + " - Tipo: " + rsTablas.getString("TABLE_TYPE"));
			}

			// --------------------------------
			// String sql = "SELECT * FROM ciclista";
			// pstmt = con.prepareStatement(sql);
			// rsTablas = pstmt.executeQuery();
			// // DatabaseMetadata
			// ResultSetMetaData rsmd = rsTablas.getMetaData();
			// int numColumnas = rsmd.getColumnCount();
			// for (int i = 1; i <= numColumnas; i++) {
			// System.out.println("Columna " + i);
			// System.out.println("Nombre: " + rsmd.getColumnName(i));
			// System.out.println("Tipo: " + rsmd.getColumnType(i));
			// System.out.println("Tipo: " + rsmd.getColumnTypeName(i));
			// System.out.println("Display Size: " + rsmd.getColumnDisplaySize(i));
			// System.out.println("ClassName: " + rsmd.getColumnClassName(i));
			// System.out.println("Label: " + rsmd.getColumnLabel(i));
			// System.out.println("Precision: " + rsmd.getPrecision(i));
			// System.out.println("Escala: " + rsmd.getScale(i));
			// System.out.println("Nullable: " + rsmd.isNullable(i));
			// System.out.println("Auto increm: " + rsmd.isAutoIncrement(i));
			// System.out.println("-----------");
			// }
			// --------------------------------

			// d. ¿Cuántas columnas tiene la tabla puerto?

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// Cerramos el ResultSet
			try {
				if (rsTablas != null && !rsTablas.isClosed()) {
					rsTablas.close();
					System.out.println("ResultSet cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
