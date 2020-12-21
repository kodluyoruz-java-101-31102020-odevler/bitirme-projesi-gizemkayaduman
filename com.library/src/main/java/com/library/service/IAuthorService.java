package com.library.service;

import java.util.List;

import com.library.dao.entity.Authors;

public interface IAuthorService {
	public Authors findByAuthorId(Long authorId);
	public List<Authors> getAllAuthorList();
	public Authors save(Authors author);
	public void update(Authors author);
	public void delete(Long authorId);
	public List<Authors> findByAuthorName(String authorName);
	

}
