package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Articulo;
import pojos.Departamento;
import pojos.ModeloArticulo;
import jdbc.ConexionJdbc;
import excepciones.BusinessException;

public class DaoModeloArticulo extends DaoGenerico<ModeloArticulo, Integer> {

	/**
	 * Persiste el modeloarticulo dado. El identificador no se genera
	 * automáticamente sino que esta incluido en el objeto dado.
	 */
	@Override
	public void grabar(ModeloArticulo m) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			// Preparar para la inserción
			String sql = "INSERT INTO modeloarticulo "
					+ "(idmodeloarticulo, nombre, descripcion, marca, modelo, tipo ) " + "VALUES (?,?,?,?,?,?)";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m.getIdmodeloarticulo());
			pstm.setString(2, m.getNombre());
			pstm.setString(3, m.getDescripcion());
			pstm.setString(4, m.getMarca());
			pstm.setString(5, m.getModelo());
			pstm.setInt(6, m.getTipo());

			// insertar
			pstm.executeUpdate();

		} catch (SQLException e) {
			throw new BusinessException("Error al insertar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void actualizar(ModeloArticulo m) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			// Preparar la actualización.
			String sql = "UPDATE modeloarticulo" + " SET nombre = ? " + ", descripcion = ?" + ", marca = ?"
					+ ", modelo = ?" + ", tipo = ?" + " WHERE idmodeloarticulo = ?";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, m.getNombre());
			pstm.setString(2, m.getDescripcion());
			pstm.setString(3, m.getMarca());
			pstm.setString(4, m.getModelo());
			pstm.setInt(5, m.getTipo());
			pstm.setInt(6, m.getIdmodeloarticulo());

			// Ejecutar la actualizacion
			pstm.executeUpdate();

		} catch (SQLException e) {
			throw new BusinessException("Error al actualizar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void grabarOActualizar(ModeloArticulo m) throws BusinessException {
		if (buscarPorId(m.getIdmodeloarticulo()) != null)
			grabar(m);
		else
			actualizar(m);
	}

	@Override
	public void borrar(ModeloArticulo m) throws BusinessException {
		borrar(m.getIdmodeloarticulo());
	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "DELETE FROM modeloarticulo WHERE idtipomodeloarticulo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new BusinessException("Error al eliminar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public ModeloArticulo buscarPorId(Integer id) throws BusinessException {
		ModeloArticulo result = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM modeloarticulo WHERE idmodeloarticulo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.first()) {
				result = new ModeloArticulo(id, rs.getString("nombre"), rs.getString("descripcion"),
						rs.getString("marca"), rs.getString("modelo"), rs.getInt("tipo"));
			}
			return result;

		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	public List<String> buscarPorTipo(Integer tipo) throws BusinessException {
		List<String> result = new ArrayList<>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM modeloarticulo WHERE tipo = ? ORDER BY idmodeloarticulo";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, tipo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("nombre"));
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	public List<ModeloArticulo> buscarPorTipoArticulo(Integer tipo) throws BusinessException {
		List<ModeloArticulo> result = new ArrayList<>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM modeloarticulo WHERE tipo = ? ORDER BY idmodeloarticulo";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, tipo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ModeloArticulo m = new ModeloArticulo(rs.getInt("idmodeloarticulo"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("tipo"));
				result.add(m);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<ModeloArticulo> buscarTodos() throws BusinessException {
		List<ModeloArticulo> result = new ArrayList<>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM modeloarticulo ORDER BY idmodeloarticulo";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ModeloArticulo m = new ModeloArticulo(rs.getInt("idmodeloarticulo"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("tipo"));
				result.add(m);
			}
			return result;

		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	public List<ModeloArticulo> filtrarPorMarcaModelo(String marca, String modelo) throws BusinessException {
		List<ModeloArticulo> result = new ArrayList<>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "select * from modeloarticulo where true ";

			if (marca != null) {
				sql += "and marca = ? ";
			}

			if (modelo != null) {
				sql += "and modelo = ? ";
			}

			pstm = con.prepareStatement(sql);

			int numParam = 1;
			if (marca != null)
				pstm.setString(numParam++, marca);
			if (modelo != null)
				pstm.setString(numParam, modelo);

			rs = pstm.executeQuery();

			while (rs.next()) {
				ModeloArticulo ma = new ModeloArticulo();
				ma.setMarca(rs.getString(1));
				ma.setModelo(rs.getString(2));
				result.add(ma);

				if (result.size() == 0) {
					System.out.println("El modelo de articulo no existe en la BD");
				} else {
					for (ModeloArticulo modArt : result) {
						System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - "
								+ rs.getString(4) + " - " + rs.getString(5) + " - " + rs.getInt(6));
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}

		return result;
	}
}
