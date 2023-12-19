package com.springmvc.service;

import com.springmvc.vo.UserVO;

public interface UserService {

	int checkDuplication(String email);

	void signup(UserVO userVO);

	void insertAuthority(String email, String string);

}
