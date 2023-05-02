package com.lokesh.cloud.employee.controller;

import com.lokesh.cloud.employee.entity.Domain;
import com.lokesh.cloud.employee.entity.Project;
import com.lokesh.cloud.employee.service.DomainService;
import com.lokesh.cloud.employee.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/v1/project")
public class DomainProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    DomainService domainService;
    /**
     *
     * @return list of projects
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Project> findAllEmployees() {
        return this
                .projectService
                .findAllEmployees();
    }
    @PostMapping(value = "/domain")
    public Mono<Domain> addDomain(@RequestBody Domain domain) {
        return this
                .domainService
                .saveDomain(domain);
    }
    @PostMapping(value = "/project")
    public Mono<Project> addProject(@RequestBody Project project) {
        return this
                .projectService
                .saveProject(project);
    }
}
