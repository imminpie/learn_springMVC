package com.springmvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.vo.AuthorityVO;
import com.springmvc.vo.UserVO;

@Repository
public class UserDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int checkDuplication(String email) {
		return this.sqlSessionTemplate.selectOne("user.checkDuplication", email);
	}

	public void signup(UserVO userVO) {
		this.sqlSessionTemplate.insert("user.signup", userVO);
	}

	public void insertAuthority(Map<String, String> map) {
		this.sqlSessionTemplate.insert("user.insertAuthority", map);
	}

	public List<UserVO> selectUsers() {
		return this.sqlSessionTemplate.selectList("user.selectUsers");
	}

	public List<AuthorityVO> selectAuthority(String email) {
		return this.sqlSessionTemplate.selectList("user.selectAuthority", email);
	}

}
