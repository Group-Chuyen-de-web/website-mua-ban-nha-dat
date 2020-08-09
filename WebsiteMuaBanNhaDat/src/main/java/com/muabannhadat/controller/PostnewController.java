package com.muabannhadat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muabannhadat.model.PostNewModel;
import com.muabannhadat.service.PostnewService;
import com.muabannhadat.validator.PostnewValidator;

@Controller
@RequestMapping(value = "/post_news")
public class PostnewController {
	@Autowired
	PostnewService postnewService;
	@Autowired
	PostnewValidator userValidator;
	
//	@PostMapping(value = "savepostnew")
//	public String savePostnew(@ModelAttribute("postnew") @Validated PostNewModel postnew, BindingResult result) {
//		
//		return "redirect:/login";
//	}
	@PostMapping(value = "savepostnew")
	public String savePostnew(@ModelAttribute("postnew") @Validated PostNewModel postnew, BindingResult result) {
		
		return "redirect:/login";
	}
	
	@PostMapping(value = "loadostnewall")
	@ResponseBody
	public String loadPostnewAll() {
		
		return "redirect:/login";
	}
	
	
}
