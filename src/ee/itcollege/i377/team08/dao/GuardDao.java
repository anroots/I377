package ee.itcollege.i377.team08.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.i377.team08.model.Guard;

@Repository
public class GuardDao extends CrudDao<Guard> implements CrudDaoInterface<Guard> {

	public GuardDao() {
		setType(Guard.class);
	}
	
	@Override
	public List<Guard> getAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<Guard> q = em.createNamedQuery("Guard.findAll",
					Guard.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Guard> getWithDeleted() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<Guard> q = em.createNamedQuery("Guard.findWithDeleted",
					Guard.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
