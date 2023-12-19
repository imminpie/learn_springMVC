package com.springmvc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.service.BookService;
import com.springmvc.vo.BookVO;
import com.springmvc.vo.ReviewVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String index(Model model) {
		List<BookVO> result = bookService.getList();
		model.addAttribute("books", result);
		return "books/index";
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String create(@ModelAttribute BookVO bookVO) {
		int affectRowCount = bookService.create(bookVO);
		if (affectRowCount == 1) {
			return "redirect:/books";
		}
		return "redirect:/books/new";
	}

	@RequestMapping(value = "/books/new", method = RequestMethod.GET)
	public String newBook() {
		return "books/new";
	}

	@RequestMapping(value = "/books/book", method = RequestMethod.GET)
	public String info(@RequestParam("id") int id, Model model) {
		BookVO book = bookService.getInfo(id);
		List<ReviewVO> reviews = bookService.getReviews(id);
		
		model.addAttribute("book", book);
		model.addAttribute("reviews", reviews);
		return "books/book";
	}
	
	@RequestMapping(value = "/books/edit/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		BookVO book = bookService.update(id);
		model.addAttribute("book", book);
		return "books/edit";
	}
	
	@RequestMapping(value = "/books/edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable int id, @ModelAttribute BookVO bookVO) {
		int affectRowCount = bookService.edit(bookVO);
		if (affectRowCount == 1) {
			return "redirect:/books/book?id=" + id;
		}
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/books/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model) {
		int affectRowCount = bookService.delete(id);
		if (affectRowCount == 1) {
			return "redirect:/books";
		}
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/books/reviews", method = RequestMethod.POST)
	public String createReviews(@ModelAttribute ReviewVO reviewVO, Principal principal) {
		reviewVO.setEmail(principal.getName());
		
		int affectRowCount = bookService.createReviews(reviewVO);
		if (affectRowCount == 1) {
			return "redirect:/books/book?id=" + reviewVO.getBookId();
		}
		return "redirect:/books/book?id=" + reviewVO.getBookId();
	}

}
