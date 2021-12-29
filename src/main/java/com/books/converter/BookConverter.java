package com.books.converter;

import com.books.model.Book;
import com.books.model.BookDto;

public class BookConverter {

    public static Book dtoToBookConverter(BookDto bookDto){
        return Book.builder()
                .isbn(bookDto.getIsbn())
                .name(bookDto.getName())
                .authors(bookDto.getAuthors())
                .country(bookDto.getCountry())
                .number_of_pages(bookDto.getNumber_of_pages())
                .publisher(bookDto.getPublisher())
                .release_date(bookDto.getRelease_date())
                .build();
    }

    public static BookDto bookToDtoConverter(Book book){
        return BookDto.builder()
                .isbn(book.getIsbn())
                .name(book.getName())
                .authors(book.getAuthors())
                .country(book.getCountry())
                .number_of_pages(book.getNumber_of_pages())
                .publisher(book.getPublisher())
                .release_date(book.getRelease_date())
                .build();
    }
}