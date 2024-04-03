package model.dao;

import java.util.List;

import model.entities.Paciente;

public interface PacienteDao {

	void insert(Paciente obj);
	void update(Paciente obj);
	void deleteByCpf(Integer cpf);
	Paciente findByCpf(Integer cpf);
	List<Paciente> findAll();
	
}
