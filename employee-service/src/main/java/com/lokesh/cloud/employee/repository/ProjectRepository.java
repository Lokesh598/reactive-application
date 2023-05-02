package com.lokesh.cloud.employee.repository;

import com.lokesh.cloud.employee.entity.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends ReactiveMongoRepository<Project, String> {
}
