package com.kaleb.spring.service;

import java.util.List;

import com.kaleb.spring.model.Book;

public interface BookService {

	
	public void createBook(Book b);
	public List<Book> getBooks();
	public Book getBook(long bookId);
	public void updateBook(long id, Book b);
	public void deleteBook(long id);
	
}
