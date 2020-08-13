package com.muabannhadat.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.muabannhadat.authentication.MyUser;
import com.muabannhadat.entity.ImagesEntity;
import com.muabannhadat.entity.PostDetailEntity;
import com.muabannhadat.entity.PostNewsEntity;
import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.PostNewModel;
import com.muabannhadat.service.ImageService;
import com.muabannhadat.service.NewsTypeService;
import com.muabannhadat.service.PackageTypeService;
import com.muabannhadat.service.PostnewService;
import com.muabannhadat.service.RoleService;
import com.muabannhadat.service.UserService;
import com.muabannhadat.validator.PostnewValidator;
import com.muabannhadat.validator.UserValidator;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	ImageService imageService;
	@Autowired
	PostnewValidator postnewValidator;
	@Autowired
	UserValidator userValidator;
	@Autowired
	PostnewService postnewService;
	@Autowired
	NewsTypeService newsTypeService;
	@Autowired
	PackageTypeService packageTypeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginCustomerPage() {
		return "index";
		
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) auth.getPrincipal();
		if (myUser != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/home");
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

		if (target.getClass() == PostNewModel.class) {
			dataBinder.setValidator(postnewValidator);
			System.out.println("Target=" + target);
		}
	}
	@RequestMapping(value = "/savepostnew", method = RequestMethod.POST)
	public String submit(@ModelAttribute("postNew") @Validated PostNewModel newModel, BindingResult result,
			@RequestParam("file") MultipartFile[] file, ModelMap modelMap) {
		System.out.println(newModel.getTitle()+newModel.getDetail().getPrice());
		if (result.hasErrors()) {
			return "PostBan";
		}

		// mapp model to entity
		PostNewsEntity entity = new PostNewsEntity();
		BeanUtils.copyProperties(newModel, entity);
		PostDetailEntity detailEntity = new PostDetailEntity();
		BeanUtils.copyProperties(newModel.getDetail(), detailEntity);
		
		// set Time
		Date sdate = new Date();
		entity.setStart_day(sdate);
		entity.setEnd_day(addDay(sdate, newModel.getNgay()));
	
		
		// add image
		detailEntity.setImages(addImage(file));
		entity.setdetail(detailEntity);
		
		//setUser
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UsersEntity usersEntity = userService.findOne(username);
		entity.setUser_id(usersEntity);
		postnewService.savePostnew(entity);
		return "redirect:/home";
		
	}

	private Date addDay(Date date, int ngay) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DAY_OF_MONTH, ngay);
		Date date2 = calendar.getTime();
		return date2;
	}
	private List<ImagesEntity> addImage(MultipartFile[] file){
		List<ImagesEntity> entities = new ArrayList<ImagesEntity>();
		for (MultipartFile multipartFile : file) {

			ImagesEntity imagesEntity = new ImagesEntity();
			try {
				imagesEntity.setImage(multipartFile.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("looix");
				e.printStackTrace();
			}
			entities.add(imagesEntity);
		}
		return entities;
	}
	@RequestMapping(value = "/post_news")
	public String postNewsPage(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		if (auth.getName().equalsIgnoreCase("anonymousUser")) {
			return "login";
			
		}
		PostNewModel postNew = new PostNewModel();
		model.addAttribute("postNew", postNew);
		session.setAttribute("types", newsTypeService.getAll());
		session.setAttribute("packages", packageTypeService.getAll());
		return "PostBan";

	}
	
	

}
