package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.aspect.annotation.MethodRunningTime;
import com.library.dao.entity.Books;
import com.library.dao.jpa.repository.BookRepository;
import com.library.service.model.BookContext;

@Service
public class BookService implements IBookService {

	@Autowired
	private BookRepository bookRepository;

	public Books findByBookId(Long bookId) {

		return bookRepository.findWithBookId(bookId);
	}

	public List<Books> getAllBookList() {

		return bookRepository.getAllBookList();
	}

	public List<Books> searchBookList(BookContext bookContext) {

		return bookRepository.searchBookList(bookContext.getBookName());

	}
    
	@MethodRunningTime(active = true)
	@Transactional
	public Long save(BookContext bookContext) {

		Long maxId = bookRepository.findMaxBookId() + 1;

		Books book = new Books();
		book.setBookId(maxId);
		book.setBookName(bookContext.getBookName());
		book.setAuthorName(bookContext.getAuthorName());
		book.setEditionDate(bookContext.getEditionDate());
		book.setBookDescription(bookContext.getBookDescription());
		book.setBookNote(bookContext.getBookNote());

		book = bookRepository.save(book);

		return book.getBookId();
	}

	@MethodRunningTime(active = true)
	@Transactional
	public Long update(BookContext bookContext) {

		Books book = bookRepository.findWithBookId(bookContext.getBookId());
		if (book == null) {
			throw new RuntimeException(bookContext.getBookId() + " ID not found in DB!");
		}

		book.setBookName(bookContext.getBookName());
		book.setAuthorName(bookContext.getAuthorName());
		book.setEditionDate(bookContext.getEditionDate());
		book.setBookDescription(bookContext.getBookDescription());
		book.setBookNote(bookContext.getBookNote());

		bookRepository.save(book);
		return book.getBookId();
	}

	@Transactional
	public Long delete(Long bookId) {

		bookRepository.deleteById(bookId);
		return bookId;
	}

}
