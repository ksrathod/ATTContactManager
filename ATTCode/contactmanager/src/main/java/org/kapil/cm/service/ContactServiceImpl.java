package org.kapil.cm.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.kapil.cm.bean.ContactBean;
import org.kapil.cm.bean.LoginBean;
import org.kapil.cm.dao.ContactDao;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactdao;

	@Override
	public void addContact(ContactBean contact) {
		contactdao.addContact(contact);
	}

	@Override
	public List<ContactBean> listContact(int id) {
		return (List<ContactBean>) contactdao.findContactById(id);
	}

	@Override
	public void remove(int id) {
		contactdao.deleteContact(id);
	}

	@Override
	public List<ContactBean> listContactAllDetails() {
		return (List<ContactBean>) contactdao.findAllContacts();

	}

	@Override
	public void updateContact(ContactBean contact) {

		contactdao.updateContact(contact);

	}

	public String authentictUser( LoginBean loginBean){
			try {
				Properties config = new Properties();
		    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
		    	InputStream is = loader.getResourceAsStream("loginuser.properties");
  		        config.load(is);
        	    String password = config.getProperty("username." + loginBean.getUserName().trim());
        			if (password != null && password.equals(loginBean.getPassword())) {
        		      	is.close();
        				return "redirect:/index";
                 } else {
                	 is.close();
        			return "login";
        			}
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "login";

}
}
