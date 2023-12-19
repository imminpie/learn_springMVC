package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.service.UserService;
import com.springmvc.vo.UserVO;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index(Model model) {
		List<UserVO> users = userService.selectUsers();
		model.addAttribute("users", users);
		return "admin/index";
	}

}
