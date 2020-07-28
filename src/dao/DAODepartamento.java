package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jdbc.ConexionJdbc;
import pojos.Departamento;
import excepciones.BusinessException;

public class DAODepartamento {
	public static Departamento getDepartamento(int idDepartamento) throws BusinessException{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Departamento d = null;
		try {
			String sql = "SELECT * FROM departamento WHERE iddepartamento= ?";
			pstm = ConexionJdbc.getConnection().prepareStatement(sql);
			pstm.setInt(1, idDepartamento);

			rs = pstm.executeQuery();
			if (rs.first()){
				d = new Departamento();
				d.setIdDepartamento(rs.getInt("iddepartamento"));
				d.setNombre(rs.getString("nombre"));
			}
			return d;
		} catch (SQLException e) {
			Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, "Error de Query",e);
			throw new BusinessException("Error en operación con la BD.");
		} finally {
			//No hace falta cerrar el rs. Si cerramos un Statement el ResultSet que depende de el 
			//se cierra automáticamente
			ConexionJdbc.cerrar(pstm);
		}
	}
}
