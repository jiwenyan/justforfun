package org.justforfun.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.justforfun.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractGenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK> {

	@SuppressWarnings("rawtypes")
	private Class entityType;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	protected AbstractGenericDaoImpl(@SuppressWarnings("rawtypes") Class type) {
		this.entityType=type;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PK save(Object entity) {
		return (PK) this.getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		this.getCurrentSession().saveOrUpdate(entity);
		
	}

	@Override
	public void persist(Object entity) {
		this.getCurrentSession().persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(PK id) {
		return (T) this.getCurrentSession().load(this.entityType, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id) {
		return (T) this.getCurrentSession().get(this.entityType, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findAll() {
		return this.getCurrentSession().createQuery("from "+this.entityType.getName())
				.setCacheable(true).list();
	}
	
	@Override
	public Criteria createCriteria(){
		return this.getCurrentSession().createCriteria(this.entityType);
	}
	
	@Override
	public void flush() {
		this.getCurrentSession().flush();
		
	}

}
