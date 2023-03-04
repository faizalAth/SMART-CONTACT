package com.smart.contact.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.contact.entities.MstUserBo;
import com.smart.contact.repository.UserRepo;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired UserRepo userRepo;
	
	@ModelAttribute
	public void beforeHandler(Model model,Principal principal) {
		if(principal != null) {
			MstUserBo user= userRepo.getUserByUserName(principal.getName());
			model.addAttribute("user",user);
		}
	}
	
	@RequestMapping("/index")
	public String userDashBoard() {
		return "user/userDashboard";
	}
	
	@RequestMapping("add-contact")
	public ModelAndView addContact() {
		return new ModelAndView("user/add-contact");
	}
}
