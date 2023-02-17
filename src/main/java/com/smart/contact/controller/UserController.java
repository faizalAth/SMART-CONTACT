package com.smart.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@RequestMapping("/index")
	public String userDashBoard() {
		return "user/userDashboard";
	}
}
