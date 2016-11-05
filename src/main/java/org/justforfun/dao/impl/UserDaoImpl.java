package org.justforfun.dao.impl;


import java.util.List;


import org.hibernate.Criteria;
import org.justforfun.dao.UserDao;
import org.justforfun.entity.Users;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDaoImpl extends AbstractGenericDaoImpl<Users, Integer> implements UserDao{

	public UserDaoImpl(){
		super(Users.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsers(Criteria query){
		return query.list();
	}

}
