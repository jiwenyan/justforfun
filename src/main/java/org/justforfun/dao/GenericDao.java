package org.justforfun.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface GenericDao <T,PK extends Serializable> {
	PK save(T entity);
	void saveOrUpdate(T entity);
	void persist(T entity);
	
	T load(PK id);
	T get(PK id);
	
	Criteria createCriteria();
	
	List<T> findAll();
	
	void flush();
}
