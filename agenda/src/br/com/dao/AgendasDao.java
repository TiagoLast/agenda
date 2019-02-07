package br.com.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.entity.Agendas;
import br.com.entity.Status;

public class AgendasDao {

	private final EntityManager manager = new JPAUtil().getEntityManager();
	
	public void adiciona(Agendas agenda) {
		manager.getTransaction().begin();
		manager.persist(agenda);
		manager.getTransaction().commit();
		manager.close();
		
	}

	public void update(Agendas agenda) {
		manager.getTransaction().begin();
		manager.merge(agenda);
		manager.getTransaction().commit();
		manager.close();
	}

	public void remove(Agendas agenda) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(agenda));
		manager.getTransaction().commit();
		manager.close();
	}

	public Agendas buscaPorId(Long id) {
		return manager.find(Agendas.class, id);
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Agendas> getPorData(Date inicio, Date fim) {
		return manager.createQuery("select a from Agendas a where a.data between :dinicio and :dfim")
				.setParameter("dinicio", inicio).setParameter("dfim", fim).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Agendas> getAll() {
		return manager.createQuery("select a from Agendas a").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Agendas> getAgendasFinalizada() {
		return (List<Agendas>) manager.createQuery("select a from agendas a where a.statu =1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agendas> getAgendasNaoFinalizada() {
		StringBuilder sql = new StringBuilder();
		sql.append("select p from agendas p where p.statu =1");
		return (List<Agendas>) manager.createQuery(sql.toString()).getResultList();
	}

	public void finalizaAgenda(Agendas agenda) {
		manager.getTransaction().begin();
		Query query = manager.createQuery("update agendas a set a.statu =:status where idagenda =:idagenda")
				.setParameter("idagenda",agenda.getIdagenda())
				.setParameter("status", agenda.getStatus());
		query.executeUpdate();
		manager.getTransaction().commit();
	}

}
