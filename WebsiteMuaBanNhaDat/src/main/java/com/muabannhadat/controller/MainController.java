package com.muabannhadat.controller;

import java.util.List;

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

import com.muabannhadat.entity.PostNewsEntity;
import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.PostDetailModel;
import com.muabannhadat.model.PostNewModel;
import com.muabannhadat.model.UserModel;
import com.muabannhadat.repository.UserRepository;
import com.muabannhadat.service.NewsTypeService;
import com.muabannhadat.service.PackageTypeService;
import com.muabannhadat.service.PostnewService;
import com.muabannhadat.service.UserService;

@Controller
public class MainController {
	@Autowired
	PostnewService postnewService;
	@Autowired
	NewsTypeService newsTypeService;
	@Autowired
	PackageTypeService packageTypeService;
	
	@RequestMapping(value = "/")
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
	public String postNewsPage(Model model) {
		PostNewModel postNew = new PostNewModel();
		model.addAttribute("postNew",postNew);
		model.addAttribute("packages",packageTypeService.getAll());
		model.addAttribute("types",newsTypeService.getAll());
		return "PostBan";
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/index";
	}
	
	// tìm kiếm
	// hiển thị (nổi bật, theo danh mục)
	// chi tiết bài viết
	// luu bài viết
	// đăng bài
	// feedback
	// comment
	// 
	@RequestMapping(value = "/showpost")
	public String showPost(Model model) {
		List<PostNewsEntity> postnews =postnewService.getAll();
		
//		PostnewMapping maping = new PostnewMapping();
		
//		List<PostNewModel> postnew = maping.toListPostnew(postnews);
//		PostNewModel post =postnew.get(1);
//		model.addAttribute("post",post);
//		model.addAttribute("listpost",postnew);
		return "showpostnew";
		
	}
	
	
}
