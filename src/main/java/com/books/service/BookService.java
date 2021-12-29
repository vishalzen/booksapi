package com.books.service;

import com.books.model.Book;
import com.books.model.BookDto;
import com.books.model.IceAndFireResponse;
import com.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    public List<BookDto> getExternalBooks(List<IceAndFireResponse> iceAndFireResponses){
        return iceAndFireResponses.stream()
                .map(iceAndFireResponse -> BookDto.builder()
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

    public Book getBookById(Integer id){
        Optional<Book> book =  bookRepository.findById(id);
        return book.orElseGet(() -> Book.builder().build());
    }

    public Book deleteBookById(Integer id){
        Book book = bookRepository.findById(id).orElse(null);
        if(Objects.nonNull(book)) bookRepository.deleteById(id);
        return book;
    }

    public Book patchBook(BookDto bookDto, Integer id){
        Book book = bookRepository.findById(id).orElse(null);
        if(Objects.nonNull(book)){
            boolean needUpdate = false;
            if(StringUtils.hasLength(bookDto.getName())){
                book.setName(bookDto.getName());
                needUpdate = true;
            }
            if(StringUtils.hasLength(bookDto.getIsbn())){
                book.setIsbn(bookDto.getIsbn());
                needUpdate = true;
            }
            if(Objects.nonNull(bookDto.getAuthors())){
                book.setAuthors(bookDto.getAuthors());
                needUpdate = true;
            }
            if(Objects.nonNull(bookDto.getNumber_of_pages())){
                book.setNumber_of_pages(bookDto.getNumber_of_pages());
                needUpdate = true;
            }
            if(StringUtils.hasLength(bookDto.getPublisher())){
                book.setPublisher(bookDto.getPublisher());
                needUpdate = true;
            }
            if(StringUtils.hasLength(bookDto.getCountry())){
                book.setCountry(bookDto.getCountry());
                needUpdate = true;
            }
            if(StringUtils.hasLength(bookDto.getRelease_date())){
                book.setRelease_date(bookDto.getRelease_date());
                needUpdate = true;
            }
            if(needUpdate){
                return bookRepository.save(book);
            }
        }
        return book;
    }
}