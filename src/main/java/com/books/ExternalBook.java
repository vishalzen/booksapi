package com.books;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExternalBook {

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

    public ExternalBook(){};

    public ExternalBook(String url, String name, String isbn, List<String> authors,
                        Integer numberOfPages, String publisher, String country,
                        String mediaType, String released, List<String> characters,
                        List<String> povCharacters) {
        this.url = url;
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.country = country;
        this.mediaType = mediaType;
        this.released = released;
        this.characters = characters;
        this.povCharacters = povCharacters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getPovCharacters() {
        return povCharacters;
    }

    public void setPovCharacters(List<String> povCharacters) {
        this.povCharacters = povCharacters;
    }
}