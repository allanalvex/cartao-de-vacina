package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cpf;

	public Paciente() {

	}

	public Paciente(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
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
		return "Vacina [cpf=" + cpf + "]";
	}

}
