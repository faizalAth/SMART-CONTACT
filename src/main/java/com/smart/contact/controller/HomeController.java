package com.smart.contact.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.contact.dao.UserDao;
import com.smart.contact.entities.MstUserBo;
import com.smart.contact.helper.Helper;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	UserDao userDao;

	@Autowired
	BCryptPasswordEncoder PasswordEncoder;
	
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
	public String openSignupPage(@ModelAttribute(value = "mstUserBo") MstUserBo user,Model model) {
		model.addAttribute("userData", user);
		return "signUP";
	}

	@PostMapping("do_register")
	public String registerUser(@Valid @ModelAttribute("mstUserBo") MstUserBo user,BindingResult results,Model model) {
		try {
			if(results.hasErrors()){
				System.out.println(results.toString());
				throw new Exception("Please Accept Terms & Conditions !!");
			}else{
				user.setRole("ROLE_USER"); 
				user.setStatus(1);
				user.setCrt_date(new Date());
				user.setPassword(PasswordEncoder.encode(user.getPassword()));
				userDao.registerUser(user);
				
				model.addAttribute("message",new Helper("User Registered Successfully !!","alert-info"));
				model.addAttribute("userData", new MstUserBo());
			}

		} catch (Exception e) {
			model.addAttribute("userData", user);
			e.printStackTrace();
			model.addAttribute("message",new Helper(e.getMessage(),"alert-danger"));
		}
		return "signUP";
	}
}
