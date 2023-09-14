package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repositery.BookRepositry;


@RestController
public class BookController {
     
	@Autowired
	private BookRepositry repositry ;
	
	@PostMapping("/addBook")
	public String saveBook( @RequestBody Book book) {
		repositry.save(book);
		return "add the book";
		
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repositry.findAll();
	}

	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repositry.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repositry.deleteById(id);
		return "book deleted with id : " + id;
	}
	
	
}
