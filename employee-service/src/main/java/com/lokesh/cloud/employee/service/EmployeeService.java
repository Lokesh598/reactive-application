package com.lokesh.cloud.employee.service;

import com.lokesh.cloud.employee.entity.Domain;
import com.lokesh.cloud.employee.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<Employee> findEmployeeByEmailId(String emailId);

//    Mono<Employee> updateEmployeeInfo(String emailId, Employee employee);
    Mono<Employee> deleteEmployeeInfo(String emailId);
    Flux<Employee> findEmployeeByDomainIdAndProjectId(String domainId, String projectId);

    Flux<Domain> findAllDomainWithProjectsAndEmployee();

}
