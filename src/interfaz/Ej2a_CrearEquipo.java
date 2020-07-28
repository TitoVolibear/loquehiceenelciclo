package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class Ej2a_CrearEquipo {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce nombre del equipo: ");
			String nombre = tec.nextLine();

			Equipo e = (Equipo) s.get(Equipo.class, nombre);
			if (e != null) {
				System.out.println("Ese equipo ya existe");
			} else {
				e = new Equipo(nombre);
				System.out.println("Introduce nombre del director del equipo: ");
				String director = tec.nextLine();
				e.setDirector(director);
				s.save(e);
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
