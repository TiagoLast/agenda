package br.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "agendas")
public class Agendas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idagenda;

	@ManyToOne
	@JoinColumn
	private Pacientes paciente;

	@ManyToOne
	@JoinColumn
	private Procedimentos procedimento;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Temporal(TemporalType.TIME)
	private Date horario;

	@ManyToOne
	@JoinColumn(name="statu_id")
	private Status statu;

	public Agendas() {
	}

	public Agendas(long idagenda, Pacientes paciente, Procedimentos procedimento, Date data, Date horario,
			Status statu) {
		super();
		this.idagenda = idagenda;
		this.paciente = paciente;
		this.procedimento = procedimento;
		this.data = data;
		this.horario = horario;
		this.statu = statu;
	}

	public long getIdagenda() {
		return idagenda;
	}

	public void setIdagenda(long idagenda) {
		this.idagenda = idagenda;
	}

	public Pacientes getPacientes() {
		return paciente;
	}

	public void setPacientes(Pacientes paciente) {
		this.paciente = paciente;
	}

	public Procedimentos getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimentos procedimento) {
		this.procedimento = procedimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Status getStatus() {
		return statu;
	}

	public void setStatus(Status statu) {
		this.statu = statu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idagenda ^ (idagenda >>> 32));
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
		Agendas other = (Agendas) obj;
		if (idagenda != other.idagenda)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendas [idagenda=" + idagenda + ", paciente=" + paciente + ", procedimento=" + procedimento + ", data="
				+ data + ", horario=" + horario + ", statu=" + statu + "]";
	}

}
