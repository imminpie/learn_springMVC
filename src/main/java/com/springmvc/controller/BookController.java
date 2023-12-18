package com.springmvc.controller;

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
		model.addAttribute("book", book);
		return "books/book";
	}
	
	@RequestMapping(value = "/books/edit/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		BookVO book = bookService.update(id);
		model.addAttribute("book", book);
		return "books/edit";
	}

}
