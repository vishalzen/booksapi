package com.books;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/books")
    public List<Book>  getBooks(){
        return bookService.getBooks();
    }
    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("/external-books")
    public List<Book> getExternalBook(@RequestParam String name) throws JsonProcessingException {
        String uri = "https://www.anapioficeandfire.com/api/books/?name=" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(uri,HttpMethod.GET,entity,Object[].class);

        Object[] objects = responseEntity.getBody();

        return bookService.getExternalBooks(objects);
    }
}