package com.startup.bar.crosscutting.persistence.repository;

import com.startup.bar.crosscutting.persistence.entity.Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface BarTablesRepository extends MongoRepository<Table, String> {

    @Query("{'nameTable': ?0}")
    Optional<Table> findByNameTable(String nameTable);
}
