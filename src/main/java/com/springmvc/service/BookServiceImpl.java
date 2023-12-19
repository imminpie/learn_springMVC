package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.BookDao;
import com.springmvc.vo.BookVO;
import com.springmvc.vo.ReviewVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	public int create(BookVO bookVO) {
		return bookDao.create(bookVO);
	}

	@Override
	public List<BookVO> getList() {
		return bookDao.getList();
	}

	@Override
	public BookVO getInfo(int id) {
		return bookDao.getInfo(id);
	}

	@Override
	public BookVO update(int id) {
		return bookDao.update(id);
	}

	@Override
	public int edit(BookVO bookVO) {
		return bookDao.edit(bookVO);
	}

	@Override
	public int delete(int id) {
		return bookDao.delete(id);
	}

	@Override
	public int createReviews(ReviewVO reviewVO) {
		return bookDao.createReviews(reviewVO);
	}

	@Override
	public List<ReviewVO> getReviews(int id) {
		return bookDao.getReviews(id);
	}

}
