package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "pacientes")
public class Pacientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idpaciente;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 14, nullable = false)
	private String cpf;
	@Column(length = 15)
	private String telefone;

	public Pacientes() {
	}

	public Pacientes(long idpaciente, String nome, String cpf, String telefone) {
		super();
		this.idpaciente = idpaciente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public long getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(long idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idpaciente ^ (idpaciente >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacientes other = (Pacientes) obj;
		if (idpaciente != other.idpaciente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pacientes [idpaciente=" + idpaciente + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
				+ "]";
	}

}
