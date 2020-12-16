package com.kaleb.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kaleb.spring.model.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private  SessionFactory sessionFactory;

	@Override
	public void createBook(Book b) {
		sessionFactory.getCurrentSession().save(b);	
	}

	@Override
	public List<Book> getBooks() {
	List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}

	@Override
	public Book getBook(long bookId) {
		Book b = sessionFactory.getCurrentSession().get(Book.class, bookId);
		return b;
	}

	@Override
	public void updateBook(long id, Book b) {
	Session session =sessionFactory.getCurrentSession();
	Book bk = session.byId(Book.class).load(id);
	bk.setAuthor(b.getAuthor());
	bk.setName(b.getName());
	session.flush();

	}

	@Override
	public void deleteBook(long id) {
	Session session =sessionFactory.getCurrentSession();
	Book b = session.byId(Book.class).load(id);
	session.delete(b);
	session.flush();
	}

}
