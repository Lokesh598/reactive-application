package com.lokesh.cloud.employee.controller;


import com.lokesh.cloud.employee.entity.Domain;
import com.lokesh.cloud.employee.entity.Employee;
import com.lokesh.cloud.employee.repository.EmployeeRepository;
import com.lokesh.cloud.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    private ModelMapper modelMapper;
    Logger log;
    @PostMapping(value = "/employee", consumes = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Employee> addEmployee(@RequestBody Employee employee) {
        return this
                .employeeRepository
                .save(employee);
    }
    @PostMapping(value = "/employees", consumes = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Flux<Employee> addAllEmployee(@RequestBody List<Employee> employee) {
        return this
                .employeeRepository.saveAll(employee);
    }
    @DeleteMapping("/delete/{emailId}")
    private Mono<ResponseEntity<String>> delete(@PathVariable("emailId") String emailId) {
        return this.employeeService.deleteEmployeeInfo(emailId)
                .flatMap(employee -> Mono.just(ResponseEntity
                        .ok("Deleted Successfully")))
                .switchIfEmpty(Mono.just(ResponseEntity
                        .notFound().build()));
    }

//    @PutMapping("/update/{emailId}")
//    private Mono<ResponseEntity<Employee>> update(@PathVariable("emailId") String emailId, @RequestBody Employee employee) {
//
//        return this.employeeService.updateEmployeeInfo(emailId, employee)
//                .flatMap(emp1 -> Mono.just(ResponseEntity
//                        .ok(emp1))).switchIfEmpty(Mono
//                        .just(ResponseEntity.notFound().build()));

//    }
    @GetMapping(value = "/domain/{domainId}/project/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Employee> getAllEmployees(@PathVariable("domainId") String domainId, @PathVariable("projectId") String projectId) {
        return this
                .employeeService
                .findEmployeeByDomainIdAndProjectId(domainId, projectId);
    }
    @GetMapping(value = "/domain/project", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Domain> getAllDomainWithProjectsAndEmployees() {
        return this
                .employeeService
                .findAllDomainWithProjectsAndEmployee();
    }

    @GetMapping(value = "/{emailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> getEmployeeByEmailId(@PathVariable("emailId") String emailId) {
//        log.info(emailId);
        return this
                .employeeService
                .findEmployeeByEmailId(emailId);
    }
}
