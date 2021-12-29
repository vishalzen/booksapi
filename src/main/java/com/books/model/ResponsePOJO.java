package com.books.model;

import lombok.*;

import java.util.List;

@Data
@Builder
public class ResponsePOJO {
    Integer status_code;
    String status;
    List<Object> data;
}
