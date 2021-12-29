package com.books.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WrapperPOJO {
    private BookDto book;
}