package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bService;
	
	@GetMapping(value="/books")
	public ResponseEntity<List<Book>>  getBooks() {
		// TODO Auto-generated constructor 
		List<Book> list = bService.getBooks();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(list));
		}			
	}
	
	@GetMapping(value="/books/{id}")
	public ResponseEntity  getBook(@PathVariable("id") int id) {
		// TODO Auto-generated constructor 
		Book book =   bService.getBook(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(book));
		}
	}
	
	@PostMapping(value="/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book returnbook = null;
		try {
			returnbook = bService.addBook(book);
			return ResponseEntity.of(Optional.of(returnbook));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
		}
	}
	
	@DeleteMapping(value="/books/{id}")
	public  ResponseEntity<Book>  deleteBook(@PathVariable("id") int id) {
		Book returnbook = null;
		try {
			returnbook = bService.deleteBook(id);
			return ResponseEntity.of(Optional.of(returnbook));
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
		}
	}
	
	@PutMapping(value="/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id , @RequestBody Book book) {	
		Book returnbook = null;
		try {
			returnbook = bService.updateBook(book ,id);
			return ResponseEntity.of(Optional.of(returnbook));
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
		}
	}
}
