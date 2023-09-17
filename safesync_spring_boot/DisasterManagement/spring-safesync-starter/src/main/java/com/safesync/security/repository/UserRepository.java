package com.safesync.security.repository;

import com.safesync.security.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
    User findByUserName(String userName);
}
