package com.example.demo.repositery;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Book;

public interface BookRepositry extends MongoRepository<Book,Integer> {

}
