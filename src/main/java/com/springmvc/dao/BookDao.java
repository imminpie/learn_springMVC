package com.springmvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.vo.BookVO;
import com.springmvc.vo.ReviewVO;

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

	public BookVO getInfo(int id) {
		return this.sqlSessionTemplate.selectOne("book.getInfo", id);
	}

	public BookVO update(int id) {
		return this.sqlSessionTemplate.selectOne("book.getInfo", id);
	}

	public int edit(BookVO bookVO) {
		return this.sqlSessionTemplate.update("book.edit", bookVO);
	}

	public int delete(int id) {
		return this.sqlSessionTemplate.delete("book.delete", id);
	}
	
	public int createReviews(ReviewVO reviewVO) {
		return this.sqlSessionTemplate.insert("book.createReviews", reviewVO);
	}

	public List<ReviewVO> getReviews(int id) {
		return this.sqlSessionTemplate.selectList("book.getReviews", id);
	}

}
