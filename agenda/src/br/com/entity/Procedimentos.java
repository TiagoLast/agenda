package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "procedimentos")
public class Procedimentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idprocedimento;

	@Column(length = 50, nullable = false)
	private String descricao;

	@Column(nullable = false)
	private double valor;

	public Procedimentos() {
	}

	public Procedimentos(long idprocedimento, String descricao, double valor) {
		super();
		this.idprocedimento = idprocedimento;
		this.descricao = descricao;
		this.valor = valor;
	}

	public long getIdprocedimento() {
		return idprocedimento;
	}

	public void setIdprocedimento(long idprocedimento) {
		this.idprocedimento = idprocedimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idprocedimento ^ (idprocedimento >>> 32));
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
		Procedimentos other = (Procedimentos) obj;
		if (idprocedimento != other.idprocedimento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procedimento [idprocedimento=" + idprocedimento + ", descricao=" + descricao + ", valor=" + valor + "]";
	}

}
