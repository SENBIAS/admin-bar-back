package com.startup.bar.crosscutting.persistence.repository;

import com.startup.bar.crosscutting.persistence.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarProductRepository extends MongoRepository<Product, String> {
}
