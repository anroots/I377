package ee.itcollege.i377.team08.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.i377.team08.model.Rank;

@Repository
public class RankDao extends CrudDao<Rank> implements CrudDaoInterface<Rank> {

	public RankDao(){
		setType(Rank.class);
	}
	
	@Override
	public List<Rank> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<Rank> query = entityManager.createNamedQuery("Rank.findAll", Rank.class);
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

	@Override
	public List<Rank> getWithDeleted() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<Rank> query = entityManager.createNamedQuery("Rank.findWithDeleted", Rank.class);
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

}
