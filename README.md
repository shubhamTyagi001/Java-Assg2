# Java-Assg2 Spring Boot Maven Project

## Project Description
This is a Spring Boot Maven project that demonstrates how to consume a REST API using Spring Boot, MongoDB, and Apache Camel. It includes functionality for creating, updating, retrieving by ID, listing, and deleting books from the API. Below are the API endpoints and the corresponding HTTP methods along with sample request body data where applicable.

### API Endpoints
1. **Create Book**
   - HTTP Method: POST
   - Endpoint: http://localhost:3005/camel/books
   - Request Body:
     ```json
     {
         "id": 1,
         "bookName": "Code Complete",
         "authorName": "Steve McConnell"
     }
     ```

2. **Update Book**
   - HTTP Method: PUT
   - Endpoint: http://localhost:3005/camel/book/update
   - Request Body:
     ```json
     {
         "id": 2,
         "bookName": "The Pragmatic Programmer",
         "authorName": "Andrew Hunt and David Thomas"
     }
     ```

3. **Get Book by ID**
   - HTTP Method: GET
   - Endpoint: http://localhost:3005/camel/book/2

4. **Get List of Books**
   - HTTP Method: GET
   - Endpoint: http://localhost:3005/camel/books

5. **Delete Book**
   - HTTP Method: DELETE
   - Endpoint: http://localhost:3005/camel/book/3

## Prerequisites
Before running this project, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MongoDB (with appropriate configuration)
- Git (optional)

## Getting Started
Follow these steps to set up and run the project on your local machine:

1. Clone the repository (if not already done):
   ```
   git clone <repository_url>
   ```

2. Navigate to the project directory:
   ```
   cd Java-Assg2
   ```

3. Build the project using Maven:
   ```
   mvn clean install
   ```

4. Run the Spring Boot application:
   ```
   mvn spring-boot:run
   ```

## Usage
Once the application is up and running, you can use tools like Postman or curl to interact with the API using the provided endpoints.

Example using curl to create a book:
```shell
curl -X POST -H "Content-Type: application/json" -d '{
    "id": 1,
    "bookName": "Code Complete",
    "authorName": "Steve McConnell"
}' http://localhost:3005/camel/books
```

Feel free to explore and test the other endpoints following a similar approach.



## Author
[Shubham Tyagi]

For any questions or issues, please contact [99shubham99tyagi@gmail.com].
