package com.books.service;

import com.books.model.Book;
import com.books.model.ExternalBook;
import com.books.model.IceAndFireResponse;
import com.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<ExternalBook> getExternalBooks(List<IceAndFireResponse> iceAndFireResponses){
        return iceAndFireResponses.stream()
                .map(iceAndFireResponse -> ExternalBook.builder()
                        .name(iceAndFireResponse.getName())
                        .isbn(iceAndFireResponse.getIsbn())
                        .authors(iceAndFireResponse.getAuthors())
                        .number_of_pages(iceAndFireResponse.getNumberOfPages())
                        .publisher(iceAndFireResponse.getPublisher())
                        .country(iceAndFireResponse.getCountry())
                        .release_date(iceAndFireResponse.getCountry())
                        .build())
                .collect(Collectors.toList());
    }

//    public Book patchBook(Map<String,Object> updates, Integer id){
//        bookRepository.
//    }
}