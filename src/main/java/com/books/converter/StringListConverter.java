package com.books.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>,String> {

    @Override
    public String convertToDatabaseColumn(List<String> stringList){
        if(stringList == null) return "";
        return String.join(",",stringList);
    }

    @Override
    public List<String> convertToEntityAttribute(String string){
        if(string == null) return Collections.emptyList();
        return Arrays.asList(string.split(","));
    }
}
