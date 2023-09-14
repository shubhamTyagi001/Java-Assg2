package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;


@Component
public class Routes extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		  restConfiguration()
          .component("servlet") // Use the servlet component for REST
          .bindingMode(RestBindingMode.json); // JSON binding, adjust as needed

      rest("/books")
          .post().consumes("application/json").type(Book.class) // POST endpoint
              .to("direct:saveBook");

      rest("/books")
          .get() // GET endpoint
              .to("direct:getBooks");

      rest("/books/{id}")
          .get("/{id}") // GET by ID endpoint
              .to("direct:getBook");

      rest("/books/{id}")
          .delete("/{id}") // DELETE by ID endpoint
              .to("direct:deleteBook");

      // Define Camel Direct Routes
      from("direct:saveBook")
          .to("bean:bookController?method=saveBook");

      from("direct:getBooks")
          .to("bean:bookController?method=getBooks");

      from("direct:getBook")
          .to("bean:bookController?method=getBook");

      from("direct:deleteBook")
          .to("bean:bookController?method=deleteBook");
 
		
	}

}
