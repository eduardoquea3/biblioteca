package com.sise.biblioteca.shared;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.sise.biblioteca.errors.ClientException;

public class ValidateSort {
    public static void Validate(String[] params, Class<?> entityClass) throws ClientException{
        Field[] fieldsClass = entityClass.getDeclaredFields();

        String[] values = Arrays.stream(fieldsClass).map(field -> field.getName()).toArray(String[]::new);
        for(String param: params){
            if(!Arrays.asList(values).contains(param)){
            throw new ClientException("Parámetro de ordenamiento no válido!", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
