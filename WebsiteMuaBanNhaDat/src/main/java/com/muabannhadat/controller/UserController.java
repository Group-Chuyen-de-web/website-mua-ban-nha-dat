package com.muabannhadat.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muabannhadat.entity.RoleEntity;
import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.UserModel;
import com.muabannhadat.service.RoleService;
import com.muabannhadat.service.UserService;
import com.muabannhadat.validator.UserValidator;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserValidator userValidator;
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public String loginCustomerPage() {
		return "index";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/index";
	}
	
	
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "redirect:/login?accessDenied";
	}
	
	

	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {

		// Form mục tiêu
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}

		if (target.getClass() == UserModel.class) {
			dataBinder.setValidator(userValidator);
			System.out.println("Target=" + target);
		}
	}

	@PostMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("userModel") @Validated UserModel userModel, BindingResult result)
			throws NoSuchAlgorithmException {
		// Nếu validate có lỗi.
		if (result.hasErrors()) {
			return "register";
		}

		UsersEntity us = new UsersEntity(userModel.getFullname(), userModel.getEmail(), userModel.getUsername(),BCrypt.hashpw(userModel.getPass(), BCrypt.gensalt(12)),
				userModel.getAddress(), userModel.getBirthday(), userModel.getPhone());
//BCrypt.hashpw(userModel.getPass(), BCrypt.gensalt(12))
		List<RoleEntity> role_id = new ArrayList<RoleEntity>();
		
		role_id.add(roleService.getRole("ADMIN"));
		
		us.setRole_id(role_id);
		us.setStatus("1");
		userService.saveUser(us);

		return "redirect:/login";
	}
	

}
