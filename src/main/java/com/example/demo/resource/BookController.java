package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repositery.BookRepositry;


@RestController
public class BookController {
     
	@Autowired
	private BookRepositry repositry ;
	
	@PostMapping("/addBook")
	public Book saveBook( @RequestBody Book book) {
		
		repositry.save(book);
		return book;
		
	}
	
	
	@PutMapping("/bookupdate")
	public Book updateBook(@RequestBody Book updatedBook) {
	    Optional<Book> optionalBook = repositry.findById(updatedBook.getId());
	    
	    if (optionalBook.isPresent()) {
	        Book existingBook = optionalBook.get();
	        
	        existingBook.setAuthorName(updatedBook.getAuthorName());
	        existingBook.setBookName(updatedBook.getBookName());
	        
	        repositry.save(existingBook);
	        
	        return existingBook; 
	    } else {

	        return null;
	    }
	}

	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repositry.findAll();
	}

	@GetMapping("/findAllBooks/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> bookOptional = repositry.findById(id);

        if (bookOptional.isPresent()) {
            return ResponseEntity.ok(bookOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repositry.deleteById(id);
		return "book deleted with id : " + id;
	}
	
	
}
