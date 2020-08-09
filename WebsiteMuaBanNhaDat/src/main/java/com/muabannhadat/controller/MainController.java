package com.muabannhadat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.UserModel;
import com.muabannhadat.repository.UserRepository;
import com.muabannhadat.service.UserService;

@Controller
public class MainController {
	
	@RequestMapping(value = "/home")
	public String homePage() {
		return "index";
		
	}
	@RequestMapping(value = "/register")
	public String registerPage(Model model) {
		UserModel userModel = new UserModel();
		model.addAttribute(userModel);
		return "register";
		
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
		
	}
	
	@RequestMapping(value = "/post_news")
	public String postNewsPage() {
		return "PostBan";
		
	}
	
	
	
	
}
