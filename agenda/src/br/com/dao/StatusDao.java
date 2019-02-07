package br.com.dao;

import javax.persistence.EntityManager;

import br.com.entity.Status;

public class StatusDao {

	private final EntityManager manager = new JPAUtil().getEntityManager();
	
	public Status buscaPorId(int id) {
		return manager.find(Status.class, id);
	}

	
	
}
