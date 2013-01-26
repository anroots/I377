package ee.itcollege.i377.team08.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ee.itcollege.i377.team08.model.DatabaseModel;

public abstract class CrudDao<T extends DatabaseModel> {

	public static final String DB_NAME = "Team08BorderGuard";

	protected EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(DB_NAME);

	private Class<T> type;

	public CrudDao<T> setType(Class<T> type) {
		this.type = type;
		return this;
	}

	public void save(T entity) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public T find(Integer id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			return em.find(type, id);
		} finally {
			em.close();
		}
	}

	public abstract List<T> getWithDeleted();

	public void truncate() {
		return; // todo
		/*
		 * EntityManager entityManager =
		 * entityManagerFactory.createEntityManager();
		 * 
		 * List<T> entities = getWithDeleted(); if (entities.size()==0){ return;
		 * } entityManager.getTransaction().begin(); for (T entity : entities){
		 * entityManager.remove(entity); }
		 * entityManager.getTransaction().commit();
		 * 
		 * entityManager.close();
		 */
	}

	public void update(T entity) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void delete(Integer id) {
		T entity = find(id);
		entity.setRemoved(new Date());
		String remover = DatabaseModel.getCurrentUserName();
		entity.setRemover(remover);
		update(entity);
	}

	public abstract List<T> getAll();

	public int countAll() {
		return getAll().size();
	}
}
