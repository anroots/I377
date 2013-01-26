package ee.itcollege.i377.team08.dao;

import java.util.List;

public interface CrudDaoInterface<T> {

	List<T> getAll();
	
	List<T> getWithDeleted();

	void save(T entity) ;
	
	T find(Integer id);
	
	void update(T entity);
	
	void delete(Integer id);
	
	int countAll();
	
}
