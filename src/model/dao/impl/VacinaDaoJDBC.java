package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.VacinaDao;
import model.entities.Paciente;
import model.entities.Vacina;

public class VacinaDaoJDBC implements VacinaDao {

	private Connection conn;

	public VacinaDaoJDBC(Connection conn) {
		this.conn = conn;

	}

	@Override
	public void insert(Vacina obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Vacina obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByCpf(Integer cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vacina findByCpf(Integer cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT vacina.*,paciente.Nome as PacNome " + "FROM vacina INNER JOIN paciente "
					+ "ON vacina.PacienteCpf = paciente.Cpf " + "WHERE vacina.Cpf = ?");

			st.setInt(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				Paciente pac = instantiatePaciente(rs);
				Vacina obj = instantiateVacina(rs, pac);
				return obj;

			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}
	}

	private Vacina instantiateVacina(ResultSet rs, Paciente pac) throws SQLException {
		Vacina obj = new Vacina();
		obj.setCpf(rs.getInt("Cpf"));
		obj.setNome(rs.getString("Nome"));
		obj.setDoseVacina(rs.getInt("DoseVacina"));
		obj.setNomeVacina(rs.getString("NomeVacina"));
		obj.setLoteVacina(rs.getInt("DoseVacina"));
		obj.setDataVacina(rs.getDate("DataVacina"));
		obj.setPaciente(pac);
		return obj;

	}

	private Paciente instantiatePaciente(ResultSet rs) throws SQLException {
		Paciente pac = new Paciente();
		pac.setCpf(rs.getInt("PacienteCpf"));
		return pac;
	}

	@Override
	public List<Vacina> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacina> findByPaciente(Paciente paciente) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT vacina.*,paciente.Nome as PacNome " + "FROM vacina INNER JOIN paciente "
					+ "ON vacina.PacienteCpf = paciente.Cpf " + "WHERE vacina.Cpf = ? " + "ORDER BY Nome");

			st.setInt(1, paciente.getCpf());

			rs = st.executeQuery();

			List<Vacina> list = new ArrayList<>();
			Map<Integer, Paciente> map = new HashMap<>();

			while (rs.next()) {

				Paciente pac = map.get(rs.getInt("PacienteCpf"));

				if (pac == null) {
					pac = instantiatePaciente(rs);
					map.put(rs.getInt("PacienteCpf"), pac);
				}

				Vacina obj = instantiateVacina(rs, pac);
				list.add(obj);

			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}
	}

}
