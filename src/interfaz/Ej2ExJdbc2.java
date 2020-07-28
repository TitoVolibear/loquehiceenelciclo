package interfaz;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoSalida;
import dao.DaoUsuario;
import jdbc.ConexionJdbc;
import pojos.Articulo;
import pojos.Salida;
import pojos.Usuario;

public class Ej2ExJdbc2 {
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
		Date fechaSalida = null;
		Date fechaDev = null;

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

			SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
			fechaSalida = sf.parse(stringFS);

			if (s.getUsuario() != null && s.getArticulo() != null && s.getFechaSalida() != null) {
				s.setUsuario(usuario);
				s.setArticulo(articulo);
				s.setFechaSalida(fechaSalida);
				s.setFechaDevolucion(fechaDev);
				daoS.grabar(s);
				System.out.println("Operacion realizada con exito");
			} else {
				if (daoUsu.buscarPorId(usuario) == null) {
					System.out.println("No existe ese usuario.");
				}
				if (daoArt.buscarPorId(articulo) == null) {
					System.out.println("No existe ese articulo.");
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
