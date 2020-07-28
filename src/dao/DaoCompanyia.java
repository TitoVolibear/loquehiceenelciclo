package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Cancion;
import pojos.Companyia;

public class DaoCompanyia extends DaoGenericoHibernate<Companyia, Integer>{
	
	private final static Logger LOGGER = Logger
			.getLogger(DaoGrupo.class.getName());

}
