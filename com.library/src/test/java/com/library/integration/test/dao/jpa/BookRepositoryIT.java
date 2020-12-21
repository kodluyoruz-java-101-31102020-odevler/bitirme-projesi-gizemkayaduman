package com.library.integration.test.dao.jpa;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.entity.Books;
import com.library.dao.jpa.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class BookRepositoryIT {

	@Autowired
	private BookRepository bookRepository;
	@Test
	@Order(1)
	public void selectBookByBookId() {
		
		Long maxId = bookRepository.findMaxBookId();
		Books book = bookRepository.findWithBookId(maxId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBookId() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@Order(2)
	public void saveBook() {
		
		Long maxId = bookRepository.findMaxBookId();
		Long newBookId = maxId + 1;
		
		Books book = new Books();
		book.setBookId(newBookId);
		book.setBookName("Kendine iyi bak");
		book.setAuthorName("Beyhan Budak");;
		book.setBookDescription("deneme");;
		book.setEditionDate(new Date());
		book.setBookNote("deneme");
		
		bookRepository.save(book);
		
		book = bookRepository.findWithBookId(newBookId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBookId() > 0);
	}
}
