package com.muabannhadat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muabannhadat.authentication.MyUser;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	//chuyen den trang admin khi dang nhap thanh cong
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginAdminPage() {
		return "index_Admin";
		
	}
	//logout ve trang index
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutAdmin(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) auth.getPrincipal();
		if (myUser != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/manager_category_Admin", method = RequestMethod.GET)
	public String managerCategoryAdminPage() {
		return "manager_category_Admin";
		
	}
}
