package com.lokesh.cloud.employee.repository;

import com.lokesh.cloud.employee.entity.Domain;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends ReactiveMongoRepository<Domain, String> {
}
