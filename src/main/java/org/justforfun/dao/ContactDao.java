package org.justforfun.dao;

import org.justforfun.entity.Contacts;

public interface ContactDao extends GenericDao<Contacts,Integer> {
	boolean checkEmailExistance(String email);
	boolean checkTelephoneExistence(String telephone);
}
