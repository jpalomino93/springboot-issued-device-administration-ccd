package com.example.template.repository;
import com.example.template.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long>{
 boolean existsByEmail(String email);
}