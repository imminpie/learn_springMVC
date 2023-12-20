package com.springmvc.service;

import java.util.List;

import com.springmvc.vo.BookVO;
import com.springmvc.vo.Criteria;
import com.springmvc.vo.ReviewVO;

public interface BookService {

	int create(BookVO bookVO);

	List<BookVO> getList();

	BookVO getInfo(int id);

	BookVO update(int id);

	int edit(BookVO bookVO);

	int delete(int id);

	List<ReviewVO> getReviews(int id, Criteria criteria);

	int createReviews(ReviewVO reviewVO);

	int getReviewsCnt(int id);

}