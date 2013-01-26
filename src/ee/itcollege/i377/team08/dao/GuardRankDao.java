package ee.itcollege.i377.team08.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.i377.team08.model.GuardRank;

@Repository
public class GuardRankDao extends CrudDao<GuardRank> implements CrudDaoInterface<GuardRank> {

	public GuardRankDao() {
		setType(GuardRank.class);
	}
	
	@Override
	public List<GuardRank> getAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<GuardRank> q = em.createNamedQuery("GuardRank.findAll",
					GuardRank.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<GuardRank> getWithDeleted() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<GuardRank> q = em.createNamedQuery("GuardRank.findWithDeleted",
					GuardRank.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
