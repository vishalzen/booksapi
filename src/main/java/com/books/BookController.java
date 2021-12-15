package com.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/books")
    public List<Book>  getBooks(){
        return bookService.getBooks();
    }
    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }



}
