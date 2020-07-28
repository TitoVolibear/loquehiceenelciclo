package interfaz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class Ej2d_CrearCiclista {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce el dorsal del ciclista: ");
			Integer dorsal = tec.nextInt();
			tec.nextLine();

			System.out.println("Introduce el nombre del ciclista: ");
			String nomCi = tec.nextLine();

			System.out.println("Introduce la fecha de nacimiento del ciclista: ");
			String fechaNac = tec.nextLine();
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha = formato.parse(fechaNac);

			System.out.println("Introduce nombre del equipo al que quieres asociar al ciclista: ");
			String nomEq = tec.nextLine();

			Ciclista c = (Ciclista) s.get(Ciclista.class, dorsal);
			Equipo e = (Equipo) s.get(Equipo.class, nomEq);

			if (c != null) {
				System.out.println("Ese ciclista ya existe");
			} else if (e == null) {
				System.out.println("Ese equipo no existe");
			} else {
				c = new Ciclista();
				c.setNombre(nomCi);
				c.setEquipo(e);
				c.setNacimiento(fecha);
				s.save(c);
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} catch (ParseException e1) {
			e1.printStackTrace();
		} finally {
			f.close();
		}
	}
}
