package com.safesync.repository;

import com.safesync.dto.Firebrigade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirebrigadeRepository extends MongoRepository<Firebrigade, Integer> {
}
