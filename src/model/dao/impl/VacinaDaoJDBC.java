package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	public void deleteById(Integer cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vacina findById(Integer cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT vacina.*,paciente.Nome as PacNome " + "FROM vacina INNER JOIN paciente "
					+ "ON vacina.PacienteCpf = paciente.Cpf " + "WHERE vacina.Cpf = ?");

			st.setInt(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				Paciente pac = new Paciente();
				pac.setCpf(rs.getInt("PacienteCpf"));
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
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}
	}

	@Override
	public List<Vacina> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
