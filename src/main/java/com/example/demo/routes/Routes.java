package com.example.demo.routes;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.processor.ProcessData;
import com.example.demo.resource.BookController;


@Component
public class Routes extends RouteBuilder{
  
	@Autowired
	private BookController book;
	
	@BeanInject
	 private ProcessData process;
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		  restConfiguration()
          .component("servlet").port(3005).host("localhost").bindingMode(RestBindingMode.json);
//		 
//		  rest()
//          .post("/books2").consumes(MediaType.APPLICATION_JSON_VALUE) // Respond to GET requests
//          .type(Book.class).outType(Book.class).route().process(process).endRest(); 
//          
//	
//		  
//		  rest()
//          .get("/hello").produces(MediaType.APPLICATION_JSON_VALUE) // Respond to GET requests
//          .route()
//          .setBody(constant("Hi!"));
     
		  rest()
          .post("/books") .consumes(MediaType.APPLICATION_JSON_VALUE)
          .type(Book.class) 
          .to("direct:saveBook");
		  
		  rest()
          .put("/book/update") .consumes(MediaType.APPLICATION_JSON_VALUE)
          .type(Book.class) 
          .to("direct:updateBook");

      rest()
          .get("/books") 
          .to("direct:getBooks");

      rest()
          .get("/book/{id}").produces(MediaType.APPLICATION_JSON_VALUE) 
          .to("direct:getBook");

      rest()
          .delete("/book/{id}") 
          .to("direct:deleteBook");

      // Define Camel Direct Routes
      from("direct:saveBook").log("Processing >>>>>>1>>>>>>>>>>>>>>>>>>>>>>>>>>>>Start")
          .to("bean:bookController?method=saveBook");
      
      from("direct:updateBook") .log("Received request to update book with ID: ${body.id}")
      .to("bean:bookController?method=updateBook");

      from("direct:getBooks")
          .to("bean:bookController?method=getBooks");

      from("direct:getBook").log(">>>>>>>>>>>>>>>>>>>>>Start")
          .to("bean:bookController?method=getBookById(${header.id})");

      from("direct:deleteBook") 
          .to("bean:bookController?method=deleteBook(${header.id})");
 
		
	}

}
