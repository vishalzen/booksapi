package com.books.controller;

import com.books.model.Book;
import com.books.model.ExtendedResponsePOJO;
import com.books.model.ResponsePOJO;
import com.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String hello(){
        return "Home of Books api";
    }

    @GetMapping("/books")
    public ResponseEntity<ResponsePOJO> getBooks(){
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(ResponsePOJO.builder()
                .status_code(HttpStatus.OK.value())
                .status("success")
                .data(new ArrayList<Object>(books))
                .build(),HttpStatus.OK
        );
    }

    @PostMapping("/books")
    public ResponseEntity<ResponsePOJO> addBook(@RequestBody Book book){
        List<Object> objects = new ArrayList<>();
        objects.add(bookService.addBook(book));
        return new ResponseEntity<>(ResponsePOJO
                .builder()
                .status_code(HttpStatus.CREATED.value())
                .status("success")
                .data(objects)
                .build(),HttpStatus.OK
        );
    }

//    @PatchMapping("/books/{id}")
//    public ResponseEntity<ExtendedResponsePOJO> patchBook(
//            @RequestBody Map<String, Object> updates,
//            @PathVariable Integer id) {
//        bookService.patchBook(updates,id);
//    }
}