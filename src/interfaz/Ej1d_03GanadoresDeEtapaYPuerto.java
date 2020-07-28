package interfaz;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Puerto;
import pojos.Etapa;

public class Ej1d_03GanadoresDeEtapaYPuerto {
	public static void main(String[] args) {
		SessionFactory f = UtilesHibernate.getSessionFactory();
		Session s = f.getCurrentSession();
		Scanner tec = new Scanner(System.in);
		try {
			s.beginTransaction();

			System.out.println("Introduce numero de etapa: ");
			int netapa = tec.nextInt();
			Etapa etapa = (Etapa) s.get(Etapa.class, netapa);
			Ciclista ciclista = etapa.getCiclista();
			System.out.println(ciclista.getNombre());
			Set<Puerto> puertos = etapa.getPuertos();
			for (Puerto p : puertos) {
				System.out.println(p.getNompuerto());
			}

			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			s.getTransaction().rollback();
		} finally {
			f.close();
		}
	}
}
