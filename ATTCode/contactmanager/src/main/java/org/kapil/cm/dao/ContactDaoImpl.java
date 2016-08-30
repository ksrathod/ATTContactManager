package org.kapil.cm.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.kapil.cm.bean.ContactBean;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl implements ContactDao {
	
	private Map<Integer,ContactBean> contacts  = new HashMap<Integer,ContactBean>();
	private Integer maxId = 0;
	
	@Override
	public Collection<ContactBean> findAllContacts() {
		Collection<ContactBean> list = new ArrayList<ContactBean>();
		for (ContactBean contact: contacts.values()) {
			list.add(contact);
		}
		return list;
	}

	@Override
	public ContactBean findContactById(Integer id) {
		return contacts.get(id);
	}

	@Override
	public ContactBean addContact(ContactBean contact) {
		Integer id = ++maxId;
		contact.setId(id);
		contacts.put(contact.getId(), contact);
		return contact;
	}

	@Override
	public ContactBean updateContact(ContactBean contact) {
		if (contacts.get(contact.getId()) == null)
			return null;
		
		contacts.put(contact.getId(), contact);
		return contact;
	}

	@Override
	public ContactBean deleteContact(Integer id) {
		return contacts.remove(id);
	}

}
