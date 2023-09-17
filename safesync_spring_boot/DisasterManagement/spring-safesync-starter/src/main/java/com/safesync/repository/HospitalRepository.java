package com.safesync.repository;

import com.safesync.dto.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface HospitalRepository extends MongoRepository<Hospital, Integer> {
}
