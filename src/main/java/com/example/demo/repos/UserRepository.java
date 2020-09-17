package com.example.demo.repos;

import com.example.demo.Models.Permissions;
import com.example.demo.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByPermissions(Permissions permissions);
}
