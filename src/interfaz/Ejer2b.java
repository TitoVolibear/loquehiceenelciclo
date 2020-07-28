package interfaz;

import java.util.List;
import java.util.Scanner;

import dao.DaoGrupo;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;

public class Ejer2b {
	public static void main(String[] args) {
		UtilesHibernate.openSession();
		DaoGrupo daoG = new DaoGrupo();
		Scanner tec = new Scanner(System.in);
		try {
			System.out.println("Introduce pais: ");
			String pais = tec.nextLine();
			List<Object[]> listaGrupos = daoG.listarGruposPorPais(pais);
			for(Object[] g : listaGrupos) {
				System.out.println("Grupo: " + g[0] + " - Artista: " + g[1] + " - Funcion: " + g[2]);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}
