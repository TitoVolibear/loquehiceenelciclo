package interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoModeloArticulo;
import jdbc.ConexionJdbc;
import pojos.ModeloArticulo;

public class Ej1ExJdbc2 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		ConexionJdbc con = null;
		DaoModeloArticulo daoModArt = new DaoModeloArticulo();
		String marca = null;
		String modelo = null;
		List<ModeloArticulo> lista = new ArrayList<>();

		try {
			con = new ConexionJdbc("configuracion//PropiedadesInventario.txt");
			con.conectar();

			System.out.println("Buscar por marca? si/no: ");
			String buscar_marca = tec.nextLine();
			if (buscar_marca.equals("si")) {
				System.out.println("Introduce la marca: ");
				marca = tec.nextLine();
			}

			System.out.println("Buscar por modelo? si/no: ");
			String buscar_modelo = tec.nextLine();
			if (buscar_modelo.equals("si")) {
				System.out.println("Introduce el modelo: ");
				modelo = tec.nextLine();
			}
			
			lista = daoModArt.filtrarPorMarcaModelo(marca, modelo);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fallo");
		} finally {
			con.desconectar();
		}
	}
}
