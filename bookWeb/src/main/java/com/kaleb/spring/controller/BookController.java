package com.kaleb.spring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaleb.spring.model.Book;
import com.kaleb.spring.service.BookService;
@CrossOrigin("*")
@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list(){
		List<Book> list = bookService.getBooks();
		return ResponseEntity.ok().body(list);
	}
	
	// A method for saving the book
	@PostMapping("/api/book")
	public void save(@RequestBody Book b)
	{
		bookService.createBook(b);
	}
	
	// To get a single record
	@GetMapping("/api/book/{bookId}")
	public ResponseEntity<Book> singleBook(@PathVariable("bookId") int bookId){
		Book b = bookService.getBook(bookId);
		return ResponseEntity.ok().body(b) ;
	}
	
	@PutMapping("/api/book/{bookId}")
	public void update(@RequestBody Book b, @PathVariable("bookId") int bookId){
		bookService.updateBook(bookId, b); ;
	}
	
	@DeleteMapping("/api/book/{bookId}")
	public void update(@PathVariable("bookId") int bookId){
		bookService.deleteBook(bookId); ;
	}
	
}
