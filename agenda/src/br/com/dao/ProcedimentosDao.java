package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.entity.Procedimentos;

public class ProcedimentosDao {

	private final EntityManager manager = new JPAUtil().getEntityManager();

	public void adiciona(Procedimentos procedimento) {
		manager.getTransaction().begin();
		manager.persist(procedimento);
		manager.getTransaction().commit();
		manager.close();
		
	}

	public void update(Procedimentos procedimento) {
		manager.getTransaction().begin();
		manager.merge(procedimento);
		manager.getTransaction().commit();
		manager.close();
	}

	public void remove(Procedimentos procedimento) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(procedimento));
		manager.getTransaction().commit();
		manager.close();
	}

	public Procedimentos buscaPorId(Long id) {
		return manager.find(Procedimentos.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Procedimentos> getAll() {
		return manager.createQuery("select p from procedimentos p").getResultList();
	}
}
