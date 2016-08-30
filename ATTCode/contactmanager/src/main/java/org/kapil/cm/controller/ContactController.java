package org.kapil.cm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.kapil.cm.bean.ContactBean;
import org.kapil.cm.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@ModelAttribute("contact")
	public ContactBean getContact() {
		ContactBean contact = new ContactBean();

		return contact;
	}

	@ModelAttribute("contacts")
	public List<ContactBean> getContacts() {
		List<ContactBean> listOfContactsAllDetails = contactService
				.listContactAllDetails();
		return listOfContactsAllDetails;
	}

	@RequestMapping({ "/index" })
	public String listContacts() {
		return "contact";
	}

	@RequestMapping(value="/add", method={RequestMethod.POST})
	public String addContact(@ModelAttribute("contact") @Valid ContactBean contact, BindingResult result, HttpServletRequest request) {
		String method = request.getMethod();
		
		if(result.hasErrors()){
			return "contact";
		}
	

		contactService.addContact(contact);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") int contactId) {

		ContactBean contact = new ContactBean();
		contact.setId(contactId);
		contactService.remove(contactId);

		return "redirect:/index";
	}

}
