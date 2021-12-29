package com.books.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IceAndFireResponse {

    @JsonProperty("url")
    private String url;

    @JsonProperty("name")
    private String name;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("authors")
    private List<String> authors;

    @JsonProperty("numberOfPages")
    private Integer numberOfPages;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("country")
    private String country;

    @JsonProperty("mediaType")
    private String mediaType;

    @JsonProperty("released")
    private String released;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("povCharacters")
    private List<String> povCharacters;
}