package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.BookDao;
import com.springmvc.vo.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	public int create(BookVO bookVO) {
		return bookDao.create(bookVO);
	}

}
