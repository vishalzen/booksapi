package com.books.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExtendedResponsePOJO{
    Integer status_code;
    String status;
    String message;
    Object data;
}