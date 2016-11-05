package org.justforfun.dao.impl;

import org.justforfun.dao.AuthenticationsDao;
import org.justforfun.entity.Authentications;
import org.springframework.stereotype.Repository;

@Repository("AuthenticationDao")
public class AuthenticationDaoImpl extends AbstractGenericDaoImpl<Authentications,Integer> implements AuthenticationsDao {

	public AuthenticationDaoImpl() {
		super(Authentications.class);
	}

}
