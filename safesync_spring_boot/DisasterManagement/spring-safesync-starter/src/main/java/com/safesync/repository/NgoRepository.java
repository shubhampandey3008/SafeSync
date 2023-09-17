package com.safesync.repository;

import com.safesync.dto.Ngo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NgoRepository extends MongoRepository<Ngo, Integer>{

}
