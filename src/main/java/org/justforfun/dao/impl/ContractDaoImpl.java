package org.justforfun.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.justforfun.dao.ContactDao;
import org.justforfun.entity.Contacts;
import org.springframework.stereotype.Repository;

@Repository("ContractDao")
public class ContractDaoImpl extends AbstractGenericDaoImpl<Contacts,Integer> implements ContactDao {

	public ContractDaoImpl() {
		super(Contacts.class);
	}
	@Override
	public boolean checkEmailExistance(String email) {
		
		String queryStr = "select 1 from contacts where email =:email";
		Query query = this.getCurrentSession().createSQLQuery(queryStr);
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<Object> result = query.list();
		return result==null?true:result.size()>0;
	}

	@Override
	public boolean checkTelephoneExistence(String telephone) {
		String queryStr = "select 1 from contacts where telephone =:telephone";
		Query query = this.getCurrentSession().createSQLQuery(queryStr);
		query.setParameter("telephone", telephone);
		@SuppressWarnings("unchecked")
		List<Object> result = query.list();
		return result==null?true:result.size()>0;
	}

}
