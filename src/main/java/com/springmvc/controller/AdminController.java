package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/admin/role/{userId}/{role}")
	public String changeRole(@PathVariable int userId, @PathVariable String role) {
		toggleRole(userId, role);
		return "redirect:/admin";
	}
	
	private void toggleRole(int userId, String role) {
		UserVO user = userService.selectUserById(userId);

		if (!user.hasRole(role)) {
			userService.insertAuthority(user.getEmail(), "ROLE_" + role.toUpperCase());
		} else {
			userService.deleteAuthority(user.getEmail(), "ROLE_" + role.toUpperCase());
		}
	}

}
