package org.justforfun.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.justforfun.entity.Users;

public interface UserDao extends GenericDao<Users,Integer> {
	
	public List<Users> getUsers(Criteria query);
}
