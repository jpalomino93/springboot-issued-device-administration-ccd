package com.example.template.service;
import com.example.template.dto.*;
import com.example.template.entity.User;
import com.example.template.exception.BusinessException;
import com.example.template.mapper.UserMapper;
import com.example.template.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
 private final UserRepository repo;
 private final UserMapper mapper;

 public UserService(UserRepository repo,UserMapper mapper){
     this.repo=repo; this.mapper=mapper;
 }

 public UserResponse create(UserRequest request){
     if(repo.existsByEmail(request.getEmail()))
         throw new BusinessException("Email ya existe: "+request.getEmail());
     User saved = repo.save(mapper.toEntity(request));
     return mapper.toResponse(saved);
 }

 public List<UserResponse> findAll(){
     return repo.findAll().stream().map(mapper::toResponse).toList();
 }
}