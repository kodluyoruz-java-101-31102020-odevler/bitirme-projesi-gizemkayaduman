package com.library.web.ui.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.dao.entity.Books;
import com.library.service.BookService;
import com.library.service.model.BookContext;

@Controller
@RequestMapping("/pages")
public class WebPageController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		List<Books> book = bookService.getAllBookList();
		model.addAttribute("book", book);
		
		return "thyme_book_list";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookSavePage(BookContext bookContext) {
		
		return "thyme_book_save";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
    public String save(BookContext bookContext, BindingResult result, Model model) {
        
		bookContext.setEditionDate(new Date());;
		
		bookService.save(bookContext);
        
		model.addAttribute("book", bookService.getAllBookList());
        
        return "thyme_book_list";
    }

	@RequestMapping(value = "/book/search", method = RequestMethod.POST)
	public String searchBookList(BookContext bookContext, BindingResult result, Model model) {
		
		List<Books> book = bookService.searchBookList(bookContext);
		model.addAttribute("book", book);
		
		return "thyme_books_list";
	}
}
