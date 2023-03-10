package com.smart.contact.controller;

import java.security.Principal;
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
import org.springframework.web.servlet.ModelAndView;

import com.smart.contact.dao.UserDao;
import com.smart.contact.entities.MstUserBo;
import com.smart.contact.helper.Helper;
import com.smart.contact.repository.UserRepo;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	UserDao userDao;

	@Autowired
	BCryptPasswordEncoder PasswordEncoder;
	
	@Autowired UserRepo userRepo;
	
	@ModelAttribute
	public void beforeHandler(Model model,Principal principal) {
		if(principal != null) {
			MstUserBo user= userRepo.getUserByUserName(principal.getName());
			model.addAttribute("user",user);
		}
	}
	
	@RequestMapping("home")
	public String openHomePage(Model model,Principal principal) {
		if(principal != null) {
			MstUserBo user = (MstUserBo) model.getAttribute("user");
			if(user != null && user.getRole().equals("ROLE_USER")) {
				return "redirect:/user/index";
			}else if(user != null && user.getRole().equals("ROLE_ADMIN")) {
				return "redirect:/admin/index";
			}else {
				return "homePage";
			}
		}else {
			return "homePage";
		}
		
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
	public ModelAndView openSignupPage(@ModelAttribute MstUserBo user,Model model) {
		model.addAttribute("userData", user);
		return new ModelAndView("signUP");
	}

	@PostMapping("do_register")
	public ModelAndView registerUser(@Valid @ModelAttribute MstUserBo user,BindingResult results,Model model) {
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
				
				model.addAttribute("message",new Helper("Registered Successfully !!","alert-info"));
				model.addAttribute("userData", new MstUserBo());
//				return new ModelAndView("redirect:/signUp","",model);
			}

		} catch (Exception e) {
			model.addAttribute("userData", user);
			e.printStackTrace();
			model.addAttribute("message",new Helper(e.getMessage(),"alert-danger"));
		}
		return new ModelAndView("signUp");
	}
	
}
