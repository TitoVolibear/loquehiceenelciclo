package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Espacio;

public class DaoEspacio extends DaoGenerico<Espacio, Integer> {

	@Override
	public void grabar(Espacio esp) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;

		try {
			String sql = "insert into espacio values(?,?,?,?)";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, esp.getIdespacio());
			pstm.setString(2, esp.getNombre());
			pstm.setString(3, esp.getDescripcion());
			pstm.setInt(4, esp.getPadre());

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;

		try {
			String sql = "delete from espacio where idespacio=?";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al eliminar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<Espacio> buscarTodos() throws BusinessException {
		List<Espacio> lista = new ArrayList<>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "select * from espacio order by idespacio";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Espacio esp = new Espacio();

				esp.setIdespacio(rs.getInt("idespacio"));
				esp.setNombre(rs.getString("nombre"));
				esp.setDescripcion(rs.getString("descripcion"));
				esp.setPadre(rs.getInt("padre"));

				lista.add(esp);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
}
