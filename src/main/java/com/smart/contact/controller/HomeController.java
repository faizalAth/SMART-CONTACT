package com.smart.contact.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.contact.dao.HomeDaoImpl;
import com.smart.contact.entities.MstUserBo;
import com.smart.contact.helper.Helper;

@Controller
public class HomeController {

@Autowired
HomeDaoImpl homeDao;

	@RequestMapping("home")
	public String openHomePage() {
		return "homePage";
	}

	@RequestMapping("about")
	public String openAboutPage() {
		return "about";
	}

	@RequestMapping("signIn")
	public String openSigninPage() {
		return "signIn";
	}

	@RequestMapping("signUp")
	public String openSignupPage(@ModelAttribute MstUserBo user,Model model) {
		model.addAttribute("userData", user);
		return "signUP";
	}

	@PostMapping("do_register")
	public String registerUser(@ModelAttribute MstUserBo user,Model model) {
		try {
			if(user.getTerms_conditions() == null){
				model.addAttribute("userData", user);
				throw new Exception("Please Accept Terms & Conditions !!");
			}else{
				user.setRole("USER_ROLE"); 
				user.setStatus(1);
				user.setCrt_date(new Date());
				homeDao.registerUser(user);
				
				model.addAttribute("message",new Helper("User Registered Successfully !!","alert-info"));
				// model.addAttribute("message_type","alert-info");
				model.addAttribute("userData", new MstUserBo());
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message",new Helper(e.getMessage(),"alert-danger"));
		}
		return "signUP";
	}
}
