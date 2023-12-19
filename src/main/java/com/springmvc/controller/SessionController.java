package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.vo.UserVO;

@Controller
public class SessionController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "statics/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		UserVO userVO = new UserVO();
		model.addAttribute("user", userVO);
		return "statics/signup";
	}

}
