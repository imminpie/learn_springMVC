package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping(value = "/signup/checkDuplication", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String checkDuplication(@RequestParam("email") String email) {
		int affectRowCount = userService.checkDuplication(email);
		return String.valueOf(affectRowCount);
	}

}
