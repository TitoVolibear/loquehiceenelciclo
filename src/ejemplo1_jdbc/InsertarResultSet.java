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

public class InsertarResultSet {
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

			// Insertar un nuevo maillot codigo = CD1, tipo = tipo1, color = Blanco, premio
			// = 100
			// Como vamos a insertar en maillot, tenemos que guardar en el DataSource la
			// tabla maillot
			sql = "select * from maillot";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();

			// Asigno valores a los campos a insertar
			rs.moveToInsertRow();
			rs.updateString(1, "CD1");
			rs.updateString(2, "tipo1");
			rs.updateString(3, "Blanco");
			rs.updateInt(4, 100);
			// Lanzo el insert
			rs.insertRow();

			// Borrar el maillot codigo "CD1"
			// sql = "select * from maillot where codigo = ?";
			// pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			// pstmt.setString(1, "CD1");
			// rs = pstmt.executeQuery();
			// rs.first();
			// rs.deleteRow();

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
