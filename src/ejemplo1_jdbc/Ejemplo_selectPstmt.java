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

// Crea una clase que lea de dado un Array con ciudad de salida de etapa y con el codigo de maillot,
//que muestre el nombre del ciclista que lo llevaba
//["Córdoba","Granada","Salamanca"]
//["MGE","MGE","MMO"]
public class Ejemplo_selectPstmt {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] salida = { "Córdoba", "Granada", "Salamanca" };
		String[] codigo = { "MGE", "MGE", "MMO" };

		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));// Ruta para conectar con SQL
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			String sql = "select ciclista.nombre from ciclista, llevar, etapa where ciclista.dorsal = llevar.dorsal and llevar.netapa = etapa.netapa and salida = ? and codigo = ?";
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < salida.length; i++) {
				pstmt.setString(1, salida[i]);
				pstmt.setString(2, codigo[i]);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println("En la etapa " + salida[i] + ": " + rs.getString(1));
				}
			}
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
