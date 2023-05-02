package com.lokesh.cloud.employee.repository;

import com.lokesh.cloud.employee.entity.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
    @Query("{emailId:?0}")
    Mono<Employee> findByEmailId(String emailId);
    @Query("{emailId:?0}")
    Mono<Employee> deleteByEmailId(String emailId);
    @Query("{'domainId':?0, 'projectId':?1}")
    Flux<Employee> findByDomainIdAndProjectId(String domainId, String projectId);
}
