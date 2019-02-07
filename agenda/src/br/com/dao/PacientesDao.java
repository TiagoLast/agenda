package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.entity.Pacientes;

public class PacientesDao {

	private final EntityManager manager = new JPAUtil().getEntityManager();

	public void adiciona(Pacientes paciente) {
		manager.getTransaction().begin();
		manager.persist(paciente);
		manager.getTransaction().commit();
		manager.close();
	}

	public void update(Pacientes paciente) {
		manager.getTransaction().begin();
		manager.merge(paciente);
		manager.getTransaction().commit();
		manager.close();
	}

	public void remove(Pacientes paciente) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(paciente));
		manager.getTransaction().commit();
		manager.close();
	}

	public Pacientes buscaPorId(Long id) {
		return manager.find(Pacientes.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pacientes> getAll() {
		return manager.createQuery("select p from pacientes p").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Pacientes> getTelefones(String nome) {
		return manager.createQuery("from pacientes where upper(nome) like :nome order by nome asc").setParameter("nome","%"+nome.toUpperCase()+"%").getResultList();
				
	}
	
}
