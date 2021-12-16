package com.books.service;

import com.books.model.Book;
import com.books.model.ExternalBook;
import com.books.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getExternalBooks(Object[] objects){
        ObjectMapper objectMapper = new ObjectMapper();
        List<ExternalBook> externalBooks =  Arrays.stream(objects)
                .map(object -> objectMapper.convertValue(object,ExternalBook.class))
                .collect(Collectors.toList());

        return externalBooks.stream()
                .map(externalBook -> new Book(externalBook.getName(),externalBook.getIsbn(),
                        externalBook.getAuthors(),externalBook.getCountry(),
                        externalBook.getNumberOfPages(),externalBook.getPublisher(),
                        externalBook.getReleased()))
                .collect(Collectors.toList());
    }
}
