package com.startup.bar.crosscutting.persistence.repository;

import com.startup.bar.crosscutting.persistence.entity.TableAuditoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditoriaRepository extends MongoRepository<TableAuditoria, String> {
}
