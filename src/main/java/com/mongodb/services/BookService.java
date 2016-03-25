package com.mongodb.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.models.Book;
import com.mongodb.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		Iterable<Book> iterable = bookRepository.findAll();
		Iterator<Book> iterator = iterable.iterator();
		List<Book> bookList= new ArrayList<Book>();
		while(iterator.hasNext()){
			bookList.add(iterator.next());
		}
		return bookList;
	}
	
}
