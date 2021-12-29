package com.books.model;

import lombok.*;
import java.util.List;

@Data
@Builder
public class BookDto {
    private String name;
    private String isbn;
    private List<String> authors;
    private Integer number_of_pages;
    private String publisher;
    private String country;
    private String release_date;
}