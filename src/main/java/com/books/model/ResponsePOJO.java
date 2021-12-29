package com.books.model;

import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ResponsePOJO {
    Integer status_code;
    String status;
    Object data;
}