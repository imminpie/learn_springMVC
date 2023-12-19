package com.springmvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int checkDuplication(String email) {
		return this.sqlSessionTemplate.selectOne("user.checkDuplication", email);
	}

}
