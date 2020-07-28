package dao;

import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;

import hibernate.UtilesHibernate;
import pojos.Disco;
import pojos.Grupo;

public class DaoDisco extends DaoGenericoHibernate<Disco, Integer> {
	private final static Logger LOGGER = Logger.getLogger(DaoDisco.class.getName());

	@SuppressWarnings("deprecation")
	public Boolean grabar_Disco(Disco d) {
		boolean correcto = false;
		Session s = UtilesHibernate.getSessionFactory().openSession();
		Grupo g = d.getGrupo();
		Date fechaDisco = d.getFecha();
		int anyo = fechaDisco.getYear();
		Set<Disco> discosGrupo = g.getDiscos();
		if(discosGrupo.size() >= 2) {
			
		}
		return correcto;
	}
}
