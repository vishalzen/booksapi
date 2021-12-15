package com.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
}
