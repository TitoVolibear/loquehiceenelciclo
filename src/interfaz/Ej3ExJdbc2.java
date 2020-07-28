package interfaz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoSalida;
import dao.DaoUsuario;
import jdbc.ConexionJdbc;
import pojos.Articulo;
import pojos.Salida;
import pojos.Usuario;

public class Ej3ExJdbc2 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		ConexionJdbc con = null;
		LocalDateTime ahora = LocalDateTime.now();
		DaoUsuario daoUsu = new DaoUsuario();
		DaoArticulo daoArt = new DaoArticulo();
		DaoSalida daoS = new DaoSalida();
		Usuario usu = null;
		Articulo art = null;
		Salida s = null;
		LocalDateTime fechaSalida = null;

		try {
			con = new ConexionJdbc("configuracion//PropiedadesInventario.txt");
			con.conectar();

			s = new Salida();

			System.out.println("Introduce usuario: ");
			Integer usuario = tec.nextInt();
			tec.nextLine();

			System.out.println("Introduce articulo: ");
			Integer articulo = tec.nextInt();
			tec.nextLine();

			// 2018-11-30 11:00:00
			System.out.println("Introduce fecha de salida: ");
			String stringFS = tec.nextLine();

			System.out.println("Introduce hora de salida");
			String stringHS = tec.nextLine();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			fechaSalida = LocalDateTime.parse(stringFS + " " + stringHS, formatter);

			if (daoUsu.buscarPorId(usuario) != null && daoArt.buscarPorId(articulo) != null) {
				if (daoS.articuloMismoDepartamento(usuario, articulo) == true) {
					daoS.grabar(s);
				} else {
					System.out.println("El usuario no es del mismo departamento que el articulo.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fallo");
		} finally {
			con.desconectar();
		}
	}
}
