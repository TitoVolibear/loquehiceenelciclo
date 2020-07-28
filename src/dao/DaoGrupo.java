package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Grupo;

public class DaoGrupo extends DaoGenericoHibernate<Grupo, Integer> {
	private final static Logger LOGGER = Logger.getLogger(DaoGrupo.class.getName());

	public List<Object[]> listarGruposPorPais(String pais) throws BusinessException {
		Session s = UtilesHibernate.getSessionFactory().openSession();
		List<Object[]> lista = null;
		try {
			s.beginTransaction();
			String hql = "select g.nombre, art.nombre, p.funcion from Grupo g join g.perteneces p join p.artista art where g.pais = :pais";
			lista = (List<Object[]>) s.createQuery(hql).setString("pais", pais).list();
			s.getTransaction().commit();
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw new BusinessException(cve);
		} catch (Exception ex) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw ex;
		}
		return lista;
	}
}
