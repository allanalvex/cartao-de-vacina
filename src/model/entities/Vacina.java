package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vacina implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cpf;
	private String nome;	
	private int doseVacina;
	private String nomeVacina;
	private int loteVacina;
	private Date dataVacina;

	private Paciente paciente;

	public Vacina() {

	}

	public Vacina(Integer cpf, String nome, int doseVacina, String nomeVacina, int loteVacina, Date dataVacina,
			Paciente paciente) {
		this.cpf = cpf;
		this.nome = nome;
		this.doseVacina = doseVacina;
		this.nomeVacina = nomeVacina;
		this.loteVacina = loteVacina;
		this.dataVacina = dataVacina;
		this.paciente = paciente;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDoseVacina() {
		return doseVacina;
	}

	public void setDoseVacina(int doseVacina) {
		this.doseVacina = doseVacina;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public int getLoteVacina() {
		return loteVacina;
	}

	public void setLoteVacina(int loteVacina) {
		this.loteVacina = loteVacina;
	}

	public Date getDataVacina() {
		return dataVacina;
	}

	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente pac) {
		this.paciente = pac;
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
		Vacina other = (Vacina) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Vacina [cpf=" + cpf + ", nome=" + nome + ", doseVacina=" + doseVacina + ", nomeVacina=" + nomeVacina
				+ ", loteVacina=" + loteVacina + ", dataVacina=" + dataVacina + ", paciente=" + paciente + "]";
	}

}
