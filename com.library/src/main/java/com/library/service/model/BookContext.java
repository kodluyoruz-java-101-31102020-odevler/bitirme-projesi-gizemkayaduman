package com.library.service.model;

import java.io.Serializable;
import java.util.Date;

public class BookContext implements Serializable{

	private static final long serialVersionUID = 6887561845986065161L;

	private Long bookId;
	private String bookName;
	private String authorName;
	private Date editionDate;
	private String bookDescription;
	private String bookNote;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getEditionDate() {
		return editionDate;
	}
	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getBookNote() {
		return bookNote;
	}
	public void setBookNote(String bookNote) {
		this.bookNote = bookNote;
	}
	
	
	
	

}
