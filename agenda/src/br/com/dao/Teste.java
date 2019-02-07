package br.com.dao;

import br.com.entity.Agendas;
import br.com.entity.Status;

public class Teste {

	public static void main(String[] args) {
		
		AgendasDao dao = new AgendasDao();
		Agendas agenda = new Agendas();
		Status statu = new Status();
		statu.setId(1);
		agenda.setIdagenda(25);
		agenda.setStatus(statu);
		dao.finalizaAgenda(agenda);
	 
	}
}
