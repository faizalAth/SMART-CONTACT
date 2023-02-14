package com.smart.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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
	public String openSignupPage() {
		return "signUP";
	}
}
