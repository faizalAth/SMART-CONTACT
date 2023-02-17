package com.smart.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

	@RequestMapping("adm_dashboard")
	public String adminDashboard() {
		return "admin/adminDashboard";
	}
}
