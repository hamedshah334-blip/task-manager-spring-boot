package com.example.taskmanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String,String>> catchException(MethodArgumentNotValidException e) {
        BindingResult r = e.getBindingResult();
        List<FieldError> errors = r.getFieldErrors();
        HashMap<String, String> map = new HashMap<>();
        for(FieldError error : errors) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(map);
    }
}
