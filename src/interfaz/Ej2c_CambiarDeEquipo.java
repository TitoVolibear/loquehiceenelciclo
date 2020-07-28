package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class Ej2c_CambiarDeEquipo {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce dorsal de ciclista: ");
			Integer dorsal = tec.nextInt();
			System.out.println("Introduce nombre de equipo: ");
			String nomeq = tec.nextLine();

			Ciclista ciclista = (Ciclista) s.get(Ciclista.class, dorsal);
			Equipo equipo = (Equipo) s.get(Equipo.class, nomeq);

			if (ciclista == null) {
				System.out.println("Ese ciclista no existe");
			} else if (equipo == null) {
				System.out.println("Ese equipo no existe");
			} else {
				if (ciclista.getEquipo().getNomeq().equals(nomeq)) {
					System.out.println("El ciclista ya esta en ese equipo");
				} else {
					ciclista.setEquipo(equipo);
					// s.update(ciclista); // <- Esta implicito en el commit
				}
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
