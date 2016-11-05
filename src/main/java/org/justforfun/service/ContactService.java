package org.justforfun.service;

import java.util.List;

import org.justforfun.entity.Contacts;

public interface ContactService {
	Contacts addContact(Contacts toAdd);
	void updat(Contacts toUpdate);
	List<Contacts> getContactByUserId(Integer user_id);
}
 