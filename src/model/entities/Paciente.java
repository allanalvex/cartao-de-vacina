package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cpf;
	private String nome;

	public Paciente() {

	}

	public Paciente(Integer id, String name) {
		this.cpf = id;
		this.nome = name;
	}

	public Integer getId() {
		return cpf;
	}

	public void setId(Integer id) {
		this.cpf = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Vacina [id=" + cpf + ", name=" + nome + "]";
	}

}
