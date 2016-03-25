package com.mongodb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mongodb.models.Book;

public interface BookRepository extends CrudRepository<Book, String> {

}
