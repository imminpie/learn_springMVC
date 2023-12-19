package com.springmvc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDao;
import com.springmvc.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public int checkDuplication(String email) {
		return userDao.checkDuplication(email);
	}

	@Override
	public void signup(UserVO userVO) {
		userDao.signup(userVO);
	}

	@Override
	public void insertAuthority(String email, String authority) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("authority", authority);
		userDao.insertAuthority(map);
	}

}
