package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.dao.entity.Books;
import com.library.service.BookService;
import com.library.service.model.BookContext;

@RestController
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
	public Books findByBookId(@PathVariable("bookId") Long bookId) {
		
		return bookService.findByBookId(bookId);
	}
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public List<Books> getAllBookList() {
		
		return bookService.getAllBookList();
	}
	
	@RequestMapping(value = "/book/search", method = RequestMethod.POST)
	public  List<Books> searchBooksList(@RequestBody BookContext bookContext) {
			
		return bookService.searchBookList(bookContext);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Long save(@RequestBody BookContext bookContext) {
			
		return bookService.save(bookContext);
	}
		
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public Long update(@RequestBody BookContext bookContext) {
		
		return bookService.update(bookContext);
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public Long delete(@PathVariable("id") Long id) {
		
		return bookService.delete(id);
	
	}

}
