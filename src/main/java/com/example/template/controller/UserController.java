package com.example.template.controller;
import com.example.template.dto.UserRequest;
import com.example.template.dto.UserResponse;
import com.example.template.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
 private final UserService service;
 public UserController(UserService service){this.service = service;}

 @PostMapping
 public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request){
     return ResponseEntity.ok(service.create(request));
 }

 @GetMapping
 public ResponseEntity<List<UserResponse>> findAll(){
     return ResponseEntity.ok(service.findAll());
 }

 @GetMapping("/health")
 public ResponseEntity<String> health(){
     return ResponseEntity.ok("OK");
 }
}