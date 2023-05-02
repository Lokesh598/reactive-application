package com.lokesh.cloud.employee.service;

import com.lokesh.cloud.employee.entity.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {
    Flux<Project> findAllEmployees();

    Mono<Project> saveProject(Project project);
}
