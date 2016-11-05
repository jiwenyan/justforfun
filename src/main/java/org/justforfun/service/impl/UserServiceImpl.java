package org.justforfun.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.justforfun.common.exceptions.BusinessException;
import org.justforfun.common.exceptions.BusinessFlows;
import org.justforfun.dao.ContactDao;
import org.justforfun.dao.UserDao;
import org.justforfun.entity.Contacts;
import org.justforfun.entity.Users;
import org.justforfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(rollbackFor=Exception.class,noRollbackFor=BusinessException.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ContactDao contactDao;

	@Override
	public Users addUser(Users toAdd) throws BusinessException {
		//check user existence
		if(toAdd.getContactses() != null){
			for(Contacts cont : toAdd.getContactses()){
				String telephone = cont.getTelephone();
				String email = cont.getEmail();
				if(this.contactDao.checkEmailExistance(email)||
					this.contactDao.checkTelephoneExistence(telephone)){
						throw new BusinessException(BusinessFlows.REGISTRATION,"The email or telephone exists already.");
					}
			}
		}
		
		int id = this.userDao.save(toAdd);
		toAdd.setId(id);
		return toAdd;
	}

	@Override
	public void updateUsers(Users toUpdate) {
		this.userDao.saveOrUpdate(toUpdate);
		
	}

	@Override
	public List<Users> findAllUsers() {
		return this.userDao.findAll();
	}
	
	@Override
	public Users findUserByName(String name){
		Criteria criteria = this.userDao.createCriteria();
		
		Criterion query = Restrictions.or(Property.forName("firstName").eq(name),
										  Property.forName("lastName").eq(name));
		
		criteria.add(query);
		
		return (Users)this.userDao.getUsers(criteria).get(0);
	}

	
	
}
