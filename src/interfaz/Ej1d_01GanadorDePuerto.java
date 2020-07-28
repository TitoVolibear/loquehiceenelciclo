package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Puerto;

public class Ej1d_01GanadorDePuerto {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce nombre de puerto: ");
			String puerto = tec.nextLine();
			Puerto p = (Puerto) s.get(Puerto.class, puerto);
			Ciclista c = p.getCiclista();
			System.out.println("El ganador del puerto fue: " + c.getNombre());

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
