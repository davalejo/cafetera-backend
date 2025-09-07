package com.cafetera.cafetera_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cafetera.cafetera_backend.entity.Productor;

public interface ProductorRepository extends MongoRepository<Productor, String> {
}
