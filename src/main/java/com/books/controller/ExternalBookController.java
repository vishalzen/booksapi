package com.books.controller;

import com.books.model.ExternalBook;
import com.books.model.IceAndFireResponse;
import com.books.model.ResponsePOJO;
import com.books.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExternalBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/external-books")
    public ResponseEntity<ResponsePOJO> getExternalBook(@RequestParam String name) {
        String uri = "https://www.anapioficeandfire.com/api/books/?name=" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,entity,Object[].class);

        Object[] objects = responseEntity.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> data;
        if (objects != null) {
            List<IceAndFireResponse> iceAndFireResponses = Arrays.stream(objects)
                    .map(object -> objectMapper.convertValue(object, IceAndFireResponse.class))
                    .collect(Collectors.toList());
            data = new ArrayList<>(bookService.getExternalBooks(iceAndFireResponses));
        }
        else data = new ArrayList<>();
        return new ResponseEntity<>(ResponsePOJO
                .builder()
                .status_code(HttpStatus.OK.value())
                .status("success")
                .data(data)
                .build(),HttpStatus.OK
        );
    }
}
