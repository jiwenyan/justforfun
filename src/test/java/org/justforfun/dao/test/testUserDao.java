package org.justforfun.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.justforfun.dao.UserDao;
import org.justforfun.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", 
									"classpath:spring-hibernate.xml" })

public class testUserDao {

	@Autowired
	private UserDao userDao;

	@Test
	public void testUserDaoFindAllSuccess() {
		this.userDao.findAll();
	}
	
	@Test
	public void testUserDaoAddUser(){
		Users user = new Users();
		user.setAge(28);
		user.setFirstName("Test");
		user.setLastName("TEST");
		
		int id = this.userDao.save(user);
		
		assertNotEquals(0, id);
	}

	@Test
	@Transactional
	public void testFindUserByName(){
		String name = "Test";
		Criteria criteria = this.userDao.createCriteria();
		criteria.add(Restrictions.eq("firstName", name));
		List<Users> users = this.userDao.getUsers(criteria);
		
		assertNotNull(users);

		System.out.println(users.get(0).getFirstName());
		System.out.println(users.get(0).getLastName());
	}
}
