 package com.api.book.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.stereotype.Component;


import com.api.book.entities.Book;

@Component
public class BookService {

	static private List<Book> list =  new ArrayList<>();
	
	static{
		list.add(new Book(1,"Title1", "Author1"));
		list.add(new Book(2,"Title2", "Author2"));
		list.add(new Book(3,"Title3", "Author3"));
	}
	
	public List<Book> getBooks(){
		return list;
	}
	
	public Book getBook(int id){
		Book returnBook = null;
			for (Book book : list) {
				if(book.getId()==id) {
					returnBook = book;
				}
			}
		return returnBook;
	}
	
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	
	public Book deleteBook(int id) {
		Book returnBook = null;
		int indexToBeDeleted = -1;
		for (Book book : list) {
			indexToBeDeleted++;
			if(book.getId()==id) {
				returnBook = book;
				break;
			}
		}
		if(indexToBeDeleted !=-1 && indexToBeDeleted < list.size()) {
			list.remove(indexToBeDeleted);
		}
		return returnBook;
	}
	
	public Book updateBook(Book bookParam , int id){
		Book returnBook = null; 
		for (Book book : list) {
			if(book.getId()==id) {
				book.setAuthor(bookParam.getAuthor());
				book.setTitle(bookParam.getTitle());
				returnBook = book;
				return returnBook;
			}
		}
		return returnBook;
	}
}
