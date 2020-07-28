package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class Ej2b_ModificarEquipo {
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
				System.out.println("Introduce nombre del nuevo director: ");
				String directorNuevo = tec.nextLine();
				e.setDirector(directorNuevo);
				//s.update(e); // <- Al hacer commit, esto no hace falta porque ya va implicito en el commit
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
