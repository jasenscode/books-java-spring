package com.example.books;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    BookRepository repository;

    //GET Requests
    // Get all books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findBookByid(Integer.parseInt(id)));
    }

    // POST Requests
    // Add new book
    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        repository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added: " + book.getName());
    }


    // DELETE Requests
    // Delete a book
    @DeleteMapping("books/{id}")
    @Transactional
    public ResponseEntity<String> removeBook(@PathVariable String id){
        repository.deleteBookByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Book with ID " + id + " has been deleted");
    }
}
