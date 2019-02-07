package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 16, nullable = false)
	private String statu;

	public Status() {
	}

	public Status(int id, String statu) {
		this.id = id;
		this.statu = statu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return statu;
	}

	public void setTipo(String statu) {
		this.statu = statu;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", statu=" + statu + "]";
	}

}
