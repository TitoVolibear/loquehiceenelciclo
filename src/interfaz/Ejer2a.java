package interfaz;

import java.util.Set;

import dao.DaoCompanyia;
import dao.DaoDisco;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Companyia;
import pojos.Disco;

public class Ejer2a {
	public static void main(String[] args) {
		UtilesHibernate.openSession();
		DaoCompanyia daoCia = new DaoCompanyia();

		try {
			Companyia nuevaCia = new Companyia();
			nuevaCia.setNombre("NEW_COMP");
			nuevaCia.setDir("C/ principal");
			nuevaCia.setTfno("23456");
			daoCia.grabar(nuevaCia);
			System.out.println(nuevaCia.getNombre() + " grabada con exito.");
			
			Companyia ciaABorrar = daoCia.buscarPorId(3);
			Set<Disco> discosCiaABorrar = ciaABorrar.getDiscos();
			for(Disco d: discosCiaABorrar) {
				d.setCompanyia(nuevaCia);
			}
			nuevaCia.setDiscos(discosCiaABorrar);
			
			ciaABorrar.setDiscos(null);
			System.out.println("Traspaso de discos entre " + nuevaCia.getNombre() + " y " + ciaABorrar.getNombre() + " exitoso.");
			
			daoCia.borrar(ciaABorrar);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}
