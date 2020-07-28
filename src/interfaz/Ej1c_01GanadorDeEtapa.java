package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Etapa;

public class Ej1c_01GanadorDeEtapa {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();
			System.out.println("Introduce numero de etapa: ");
			int netapa = tec.nextInt();

			Etapa e = (Etapa) s.get(Etapa.class, netapa);
			if (e != null) {
				System.out.println("El ciclista ganador de la etapa: " + e.getCiclista());
			} else {
				System.out.println("La etapa no existe");
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
