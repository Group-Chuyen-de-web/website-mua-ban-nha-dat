package com.muabannhadat.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muabannhadat.entity.PostNewsEntity;
import com.muabannhadat.entity.RoleEntity;
import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.PostDetailModel;
import com.muabannhadat.model.PostNewModel;
import com.muabannhadat.model.UserModel;
import com.muabannhadat.repository.UserRepository;
import com.muabannhadat.service.ImageService;
import com.muabannhadat.service.NewsTypeService;
import com.muabannhadat.service.PackageTypeService;
import com.muabannhadat.service.PostnewService;
import com.muabannhadat.service.RoleService;
import com.muabannhadat.service.UserService;
import com.muabannhadat.validator.UserValidator;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@Autowired
	UserValidator userValidator;
	@Autowired
	PostnewService postnewService;
	@Autowired
	NewsTypeService newsTypeService;
	@Autowired
	PackageTypeService packageTypeService;
	@Autowired
	ImageService imageService;

	@RequestMapping(value = "/home")
	public String homePage(Model model) {
		model.addAttribute("typeAll", newsTypeService.getAll());
		return "index";

	}

	@RequestMapping(value = "/getImage/{id}")
	public void getImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/png");
		byte[] bs = imageService.getOne(id).getImage();
		InputStream inputStream = new ByteArrayInputStream(bs);
		IOUtils.copy(inputStream, response.getOutputStream());
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

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactPage() {
		return "lienhe";

	}

	@RequestMapping(value = "/guide", method = RequestMethod.GET)
	public String guidePage() {
		return "guide";

	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testPage() {
		return "NewFile1";

	}


	@RequestMapping(value = "/post_news")
	public String postNewsPage(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		if (auth.getName().equalsIgnoreCase("anonymousUser")) {
			return "redirect:/login";

		}

		return "redirect:/user/post_news";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home";
	}

	// tìm kiếm
	// luu bài viết
	// feedback
	// comment
	// hiển thị (nổi bật, theo danh mục)//còn nổi bật
	// chi tiết bài viết //gần xong
	// đăng bài //còn giá + thanh toán
	// Bổ sung: lịch sử thanh toán

	@RequestMapping(value = "/showDetail")
	public String showDetail(Model model, long id) {
		model.addAttribute("post", postnewService.getOne(id));
		return "single";
	}

	@RequestMapping(value = "/showpost")
	public String showPost(Model model) {
		List<PostNewsEntity> postnews = postnewService.getAll();
		return "showpostnew";

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
		UsersEntity us = new UsersEntity();
		BeanUtils.copyProperties(userModel, us, "username", "pass");
		us.setUsername(userModel.getUsername().toLowerCase());
		us.setPass(BCrypt.hashpw(userModel.getPass(), BCrypt.gensalt(12)));

		List<RoleEntity> role_id = new ArrayList<RoleEntity>();

		role_id.add(roleService.getRole("USER"));

		us.setRole_id(role_id);
		us.setStatus("1");
		userService.saveUser(us);

		return "redirect:/login";
	}

}
