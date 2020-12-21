package com.library.dao.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.library.dao.entity.Authors;

public interface AuthorRepository extends CrudRepository<Authors, Long>{

	@Query(value = "SELECT a FROM Authors a WHERE a.authorId = :authorId")
	public Authors findWithAuthorId(@Param("authorId") Long authorId);
	
	@Query(value = "SELECT a FROM Authors a")
	public List<Authors> getAllAuthorList();
	
	@Query(value = "SELECT MAX(a.authorId) FROM Authors a")
	public Long findMaxAuthorId();
	
	@Query("Select a FROM Authors a WHERE a.authorName = :authorName ")
	public List<Authors> findByAuthorName(@Param("authorName") String authorName);
}
