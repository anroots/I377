package ee.itcollege.i377.team08.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.i377.team08.model.RankType;

@Repository
public class RankTypeDao extends CrudDao<RankType> implements CrudDaoInterface<RankType> {

	public RankTypeDao(){
		setType(RankType.class);
	}
	
	@Override
	public List<RankType> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<RankType> query = entityManager.createNamedQuery("RankType.findAll", RankType.class);
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

	@Override
	public List<RankType> getWithDeleted() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<RankType> query = entityManager.createNamedQuery("RankType.findWithDeleted", RankType.class);
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

}
