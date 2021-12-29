package com.books.model;

import lombok.Data;

import java.util.List;

public class ExtendedResponsePOJO extends ResponsePOJO {
    String message;

    ExtendedResponsePOJO(Integer status_code, String status, List<Object> data) {
        super(status_code, status, data);
    }
}