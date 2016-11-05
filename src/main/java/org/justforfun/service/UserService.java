package org.justforfun.service;

import java.util.List;

import org.justforfun.common.exceptions.BusinessException;
import org.justforfun.entity.Users;

public interface UserService {
	Users addUser(Users toAdd) throws BusinessException;
	void updateUsers(Users toUpdate);
	List<Users> findAllUsers();
	Users findUserByName(String name);
}
