package com.example.template.mapper;

import com.example.template.dto.UserRequest;
import com.example.template.dto.UserResponse;
import com.example.template.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

 @Mapping(target = "id", ignore = true)
 @Mapping(source = "name",  target = "name")
 @Mapping(source = "email", target = "email")
 User toEntity(UserRequest request);

 @Mapping(source = "id",    target = "id")
 @Mapping(source = "name",  target = "name")
 @Mapping(source = "email", target = "email")
 UserResponse toResponse(User entity);

 @Mapping(target = "id", ignore = true)
 void updateEntityFromRequest(UserRequest request, @MappingTarget User entity);
}
