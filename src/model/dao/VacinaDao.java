package model.dao;

import java.util.List;

import model.entities.Paciente;
import model.entities.Vacina;

public interface VacinaDao {

	void insert(Vacina obj);
	void update(Vacina obj);
	void deleteByCpf(Integer cpf);
	Vacina findByCpf(Integer cpf);
	List<Vacina> findAll();
	List<Vacina> findByPaciente (Paciente paciente);
}
