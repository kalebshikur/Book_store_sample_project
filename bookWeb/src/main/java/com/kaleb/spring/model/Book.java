package com.kaleb.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Book")
public class Book {
	
		// This annotaion is used to auto generate the id after each insertion 
		// if you want any other Generation type you can use GenerationType.SEQUENCE WITH THE SYNTAX
		// @GenerationValue(strategy = GenerationType.SEQUENCE, generator = "exampleSequenceGenerator")
		// @SequenceGenerator(name="exampleSequenceGenerator", sequenceName = "id_sequence_name"
		// other restriction can also be applied using @Colomn(name="id", updatable =false, nullable=false)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE) 
	private Long id;
	private String name;
	private String author;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
}
