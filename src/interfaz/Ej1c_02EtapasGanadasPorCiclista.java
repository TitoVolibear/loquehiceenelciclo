package interfaz;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;

public class Ej1c_02EtapasGanadasPorCiclista {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce dorsal: ");
			int dorsal = tec.nextInt();
			Ciclista c = (Ciclista) s.get(Ciclista.class, dorsal);
			if (c != null) {
				Set<Etapa> etapas = c.getEtapas();
				for (Etapa e : etapas) {
					System.out.println("Salida: " + e.getSalida() + " --- Llegada: " + e.getLlegada());
				}
			} else {
				System.out.println("Ese ciclista no existe");
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
