package com.example.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.resource.BookController;

@Component
public class ProcessData implements Processor {

	@Autowired
	private BookController book;
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		book.saveBook(exchange.getIn().getBody(Book.class));
		
	}

}
