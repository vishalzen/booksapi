package com.books.model;

import com.books.converter.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String isbn;
    @Convert(converter = StringListConverter.class)
    private List<String> authors;
    private Integer number_of_pages;
    private String publisher;
    private String country;
    private String release_date;
}