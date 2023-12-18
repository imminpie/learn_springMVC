package com.springmvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.vo.BookVO;

@Repository
public class BookDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int create(BookVO bookVO) {
		return this.sqlSessionTemplate.insert("book.create", bookVO);
	}

	public List<BookVO> getList() {
		return this.sqlSessionTemplate.selectList("book.getList");
	}

}
