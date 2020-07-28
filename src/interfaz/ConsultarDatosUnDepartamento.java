package interfaz;

import java.util.Scanner;

import jdbc.ConexionJdbc;
import dao.DAODepartamento;
import excepciones.BusinessException;
import pojos.Departamento;

public class ConsultarDatosUnDepartamento {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.println("Introduce el numero de departamento a consultar: ");
		int numDepartamento = tec.nextInt();

		ConexionJdbc conJdbc = null;
		try {
			// Crea un objeto ConexionJdbc y conecta
			conJdbc = new ConexionJdbc("configuracion//PropiedadesInventario.txt");
			conJdbc.conectar();

			Departamento d = DAODepartamento.getDepartamento(numDepartamento);
			if (d == null)
				System.out.println("No hay ningún departamento con ese numero");
			else
				System.out.println("El nombre del departamento es: " + d.getNombre());
		} catch (BusinessException e) {
			System.out.println("No se pudo hacer la consulta");
		} finally {
			conJdbc.desconectar();
		}
	}
}
