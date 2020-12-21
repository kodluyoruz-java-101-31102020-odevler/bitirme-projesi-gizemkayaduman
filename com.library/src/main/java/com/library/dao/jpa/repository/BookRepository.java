package com.library.dao.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.library.dao.entity.Books;


public interface BookRepository extends CrudRepository<Books, Long>{
	
	@Query(value = "SELECT b FROM Books b WHERE b.bookId = :bookId")
	public Books findWithBookId(@Param("bookId") Long bookId);
	
	@Query(value = "SELECT MAX(b.bookId) FROM Books b")
	public Long findMaxBookId();
	
	@Query(value = "SELECT b FROM Books b")
	public List<Books> getAllBookList();
	
	@Query(value = "SELECT * FROM Books b WHERE b.bookName like '%bookName%'", nativeQuery = true)
	public List<Books> searchBookList(@Param("BookName") String bookName);

}
