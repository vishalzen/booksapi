package com.books;

import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Book {
    private String name;
    @Id
    private String isbn;
    @Convert(converter = StringListConverter.class)
    private List<String> authors;
    private String country;
    private Integer number_of_pages;
    private String publisher;
    private String release_date;

    public Book(){

    }
    public Book(String name, String isbn, List<String> authors, String country, Integer number_of_pages, String publisher, String release_date) {
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
        this.country = country;
        this.number_of_pages = number_of_pages;
        this.publisher = publisher;
        this.release_date = release_date;
    }

    public Book(Object o) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(Integer number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
