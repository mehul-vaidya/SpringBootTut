 package com.api.book.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {

	@Autowired
	BookRepository bookRepository;
	/*
	static private List<Book> list =  new ArrayList<>();
	
	static{
		list.add(new Book(1,"Title1", "Author1"));
		list.add(new Book(2,"Title2", "Author2"));
		list.add(new Book(3,"Title3", "Author3"));
	}
	*/
	
	public List<Book> getBooks(){
		return (List<Book>) bookRepository.findAll();
	}
	
	public Book getBook(int id){
		return bookRepository.findById(id);
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book deleteBook(int id) {
		 Book book = bookRepository.findById(id);
		 bookRepository.deleteById(id);
		 return book;
	}
	
	public Book updateBook(Book book , int id){
		book.setId(id);
		return bookRepository.save(book);
	}
}
