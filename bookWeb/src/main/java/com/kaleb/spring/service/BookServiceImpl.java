package com.kaleb.spring.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaleb.spring.dao.BookDao;
import com.kaleb.spring.model.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Override
	@Transactional
	public void createBook(Book b) {
		bookDao.createBook(b);
	}

	@Override
	@Transactional
	public List<Book> getBooks() {
	return bookDao.getBooks();
	}

	@Override
	@Transactional
	public Book getBook(long bookId) {
		return bookDao.getBook(bookId);
	}

	@Override
	@Transactional
	public void updateBook(long id, Book b) {
	bookDao.updateBook(id, b);
		
	}

	@Override
	@Transactional
	public void deleteBook(long id) {
		bookDao.deleteBook(id);
		
	}

}
