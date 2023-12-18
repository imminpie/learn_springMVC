package com.springmvc.service;

import java.util.List;

import com.springmvc.vo.BookVO;

public interface BookService {

	int create(BookVO bookVO);

	List<BookVO> getList();

	BookVO getInfo(int id);

}