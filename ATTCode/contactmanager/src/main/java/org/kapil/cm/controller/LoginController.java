package org.kapil.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.kapil.cm.bean.LoginBean;
import org.kapil.cm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
    	if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
             return contactService.authentictUser(loginBean);
			}
       else {
        	model.addAttribute("error", "Please enter Details");
            return "login";
			}	    	
}
}