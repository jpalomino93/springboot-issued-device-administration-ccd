package com.example.template.exception;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(BusinessException.class)
 public ResponseEntity<Map<String,Object>> handleBusiness(BusinessException ex){
     Map<String,Object> body=new HashMap<>();
     body.put("type","business-error");
     body.put("detail",ex.getMessage());
     body.put("timestamp", LocalDateTime.now());
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
 }

 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String,Object>> handleValidation(MethodArgumentNotValidException ex){
     Map<String,String> errors=new HashMap<>();
     ex.getBindingResult().getFieldErrors()
             .forEach(err->errors.put(err.getField(),err.getDefaultMessage()));

     Map<String,Object> body=new HashMap<>();
     body.put("type","validation-error");
     body.put("errors",errors);
     body.put("timestamp",LocalDateTime.now());
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
 }
}