package com.books.controller;

import com.books.converter.BookConverter;
import com.books.model.*;
import com.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

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
    public ResponseEntity<ResponsePOJO> addBook(@RequestBody BookDto bookDto){
        List<Object> objects = new ArrayList<>();
        Book book = BookConverter.dtoToBookConverter(bookDto);
        bookService.addBook(book);
        WrapperPOJO wrapperPOJO = new WrapperPOJO(bookDto);
        objects.add(wrapperPOJO);
        return new ResponseEntity<>(ResponsePOJO
                .builder()
                .status_code(HttpStatus.CREATED.value())
                .status("success")
                .data(objects)
                .build(),HttpStatus.OK
        );
    }

    @GetMapping("books/{id}")
    public ResponseEntity<ResponsePOJO> getBookById(@PathVariable Integer id){
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(ResponsePOJO
                .builder()
                .status_code(HttpStatus.OK.value())
                .status("success")
                .data(book)
                .build(),HttpStatus.OK
        );
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<ExtendedResponsePOJO> patchBook(
            @RequestBody BookDto bookDto,
            @PathVariable Integer id) {
        String bookName = bookService.getBookById(id).getName();
        Book book = bookService.patchBook(bookDto,id);
        ExtendedResponsePOJO responsePOJO = ExtendedResponsePOJO
                .builder()
                .status_code(HttpStatus.OK.value())
                .status("success")
                .build();
        if(Objects.nonNull(book)){
            responsePOJO.setMessage("The Book " + bookName + " was updated successfully");
            responsePOJO.setData(book);
            return new ResponseEntity<>(responsePOJO, HttpStatus.OK);
        }
        responsePOJO.setMessage("No book found with id = " + id);
        return new ResponseEntity<>(responsePOJO,HttpStatus.OK);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<ExtendedResponsePOJO> deleteBookById(@PathVariable Integer id){
        Book book = bookService.deleteBookById(id);
        ExtendedResponsePOJO responsePOJO = ExtendedResponsePOJO
                .builder()
                .status_code(HttpStatus.OK.value())
                .status("success")
                .data(new ArrayList<>())
                .build();
        if(Objects.nonNull(book)){
            responsePOJO.setMessage("The Book " + book.getName() + " was deleted successfully");
            return new ResponseEntity<>(responsePOJO, HttpStatus.OK);
        }
        responsePOJO.setMessage("No book found with id = " + id);
        return new ResponseEntity<>(responsePOJO,HttpStatus.OK);
    }
}