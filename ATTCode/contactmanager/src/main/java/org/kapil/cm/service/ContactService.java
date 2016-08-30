package org.kapil.cm.service;

import java.util.List;

import org.kapil.cm.bean.ContactBean;
import org.kapil.cm.bean.LoginBean;

public interface ContactService {
	public void addContact(ContactBean contact);

	public List<ContactBean> listContact(int id);

	public List<ContactBean> listContactAllDetails();

	public void remove(int id);

	public void updateContact(ContactBean contact);
	
	public String authentictUser( LoginBean loginBean);
}
