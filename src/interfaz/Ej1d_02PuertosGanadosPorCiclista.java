package interfaz;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Puerto;

public class Ej1d_02PuertosGanadosPorCiclista {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce dorsal: ");
			int dorsal = tec.nextInt();
			Ciclista c = (Ciclista) s.get(Ciclista.class, dorsal);
			Set<Puerto> puertos = c.getPuertos();
			for (Puerto p : puertos) {
				System.out.println("Nombre: " + p.getNompuerto() + " -- Altura: " + p.getAltura() + " -- Categoria: "
						+ p.getCategoria());
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
