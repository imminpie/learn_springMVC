package com.springmvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDao;
import com.springmvc.vo.AuthorityVO;
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

	@Override
	public List<UserVO> selectUsers() {
		List<UserVO> users = userDao.selectUsers();
		List<UserVO> list = new ArrayList<UserVO>();

		for (UserVO user : users) {
			String email = user.getEmail();
			List<AuthorityVO> authorities = userDao.selectAuthority(email);

			UserVO userVO = new UserVO();
			userVO.setId(user.getId());
			userVO.setEmail(email);
			userVO.setAuthorities(authorities);

			list.add(userVO);
		}
		return list;
	}

	@Override
	public UserVO selectUserById(int userId) {
		UserVO user = userDao.selectUserById(userId);
		List<AuthorityVO> authorities = userDao.selectAuthority(user.getEmail());
		user.setAuthorities(authorities);
		return user;
	}

	@Override
	public void deleteAuthority(String email, String role) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("role", role);
		userDao.deleteAuthority(map);
	}

}
