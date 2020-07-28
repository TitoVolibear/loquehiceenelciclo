package interfaz;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class Ej1c_03EtapasGanadasPorEquipo {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce nombre de equipo: ");
			String nomeq = tec.nextLine();
			Equipo e = (Equipo) s.get(Equipo.class, nomeq);
			if (e != null) {
				System.out.println("El equipo " + e.getNomeq() + " del director " + e.getDirector());
				Set<Ciclista> ciclistas = e.getCiclistas();
				for (Ciclista c : ciclistas) {
					System.out
							.println("El ciclista " + c.getNombre() + "ha ganado " + c.getEtapas().size() + " etapas");
				}
			} else {
				System.out.println("Ese equipo no existe");
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
