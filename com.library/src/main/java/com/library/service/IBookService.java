package com.library.service;

import java.util.List;

import com.library.dao.entity.Books;
import com.library.service.model.BookContext;

public interface IBookService {
	
	public Books findByBookId(Long bookId);
	public List<Books> getAllBookList();
	public Long save(BookContext bookContext);
	public Long update(BookContext bookContext);
	public Long delete(Long bookId);
	public List<Books> searchBookList(BookContext bookContext);

}
