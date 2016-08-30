package org.kapil.cm.dao;

import java.util.Collection;

import org.kapil.cm.bean.ContactBean;

public interface ContactDao {

	public Collection<ContactBean> findAllContacts();
	public ContactBean findContactById(Integer id);
	public ContactBean addContact(ContactBean contact);
	public ContactBean updateContact(ContactBean contact);
	public ContactBean deleteContact(Integer id);

}
