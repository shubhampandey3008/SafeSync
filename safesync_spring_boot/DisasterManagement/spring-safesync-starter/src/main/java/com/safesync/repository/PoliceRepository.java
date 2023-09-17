package com.safesync.repository;

import com.safesync.dto.Police;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PoliceRepository extends MongoRepository<Police, Integer> {
}
