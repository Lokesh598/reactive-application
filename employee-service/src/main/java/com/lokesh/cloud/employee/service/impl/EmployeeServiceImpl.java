package com.lokesh.cloud.employee.service.impl;

import com.lokesh.cloud.employee.entity.Domain;
import com.lokesh.cloud.employee.entity.Employee;
import com.lokesh.cloud.employee.entity.Project;
import com.lokesh.cloud.employee.repository.EmployeeRepository;
import com.lokesh.cloud.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;
    @Override
    public Mono<Employee> findEmployeeByEmailId(String emailId) {
        return this
                .employeeRepository
                .findByEmailId(emailId);
    }

    @Override
    public Flux<Employee> findEmployeeByDomainIdAndProjectId(String domainId, String projectId) {
        return employeeRepository
                .findByDomainIdAndProjectId(domainId, projectId);
    }

    @Override
    public Flux<Domain> findAllDomainWithProjectsAndEmployee() {
        return reactiveMongoTemplate.findAll(Domain.class)
                .flatMap(domain -> {
                    // Fetch projects for the domain

//                    Criteria criteria = Criteria.where("domainId").is(domain.getId());
//                    Query query = Query.query(criteria);
//                    Flux<Employee> employee = reactiveMongoTemplate.find(query, Employee.class);
                    Flux<Project> projectFlux = reactiveMongoTemplate.find(
                            Query.query(Criteria.where("domainId").is(domain.getId())),
                            Project.class);
                    System.out.println(projectFlux);
                    // Fetch employees for the domain
                    Flux<Employee> employeeFlux = reactiveMongoTemplate.find(
                            Query.query(Criteria.where("domainId").is(domain.getId())),
                            Employee.class);

                    return Flux.zip(projectFlux.collectList(), employeeFlux.collectList())
                            .map(tuple -> {
                                domain.setProjects(tuple.getT1());
                                domain.setEmployees(tuple.getT2());
                                return domain;
                            });
                });
    }


    //    @Override
//    public Mono<Employee> updateEmployeeInfo(String emailId, Employee employee) {
//        return this.employeeRepository.findByEmailId(emailId)
//                .flatMap(e -> {
//                    e.setEmailId(emailId);
//                    e.setDesignation(employee.getDesignation());
//                    e.setProjectName(employee.getProjectName());
//                    e.setAccountName(employee.getAccountName());
//                    return save(e);
//                }).switchIfEmpty(Mono.empty());
//    }
    @Override
    public Mono<Employee> deleteEmployeeInfo(String emailId) {
            return this.employeeRepository
                    .findByEmailId(emailId).flatMap(e ->
                            this.employeeRepository
                                    .deleteById(e.getId())
                                    .thenReturn(e));
    }

    private Mono<Employee> save(Employee employee) {
        return this.employeeRepository.save(employee);
    }
}
