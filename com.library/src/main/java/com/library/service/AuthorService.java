package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.entity.Authors;
import com.library.dao.jpa.repository.AuthorRepository;

@Service
public class AuthorService implements IAuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Authors findByAuthorId(Long authorId) {

		return authorRepository.findWithAuthorId(authorId);
	}

	public List<Authors> getAllAuthorList() {

		return authorRepository.getAllAuthorList();
	}


	@Transactional
	public Authors save(Authors author) {
		return authorRepository.save(author);
	}
	
	@Transactional
	public void update(Authors author) {
		authorRepository.save(author);

	}
	
	@Transactional
	public void delete(Long authorId) {
		if (authorRepository.findById(authorId)!=null)
			authorRepository.deleteById(authorId);

	}

	public List<Authors> findByAuthorName(String authorName) { 
		return authorRepository.findByAuthorName(authorName);
	}
	

}
