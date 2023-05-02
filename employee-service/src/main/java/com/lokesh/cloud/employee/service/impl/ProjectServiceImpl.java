package com.lokesh.cloud.employee.service.impl;

import com.lokesh.cloud.employee.entity.Project;
import com.lokesh.cloud.employee.repository.ProjectRepository;
import com.lokesh.cloud.employee.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;


    @Override
    public Flux<Project> findAllEmployees() {
        return this.projectRepository.findAll();
    }

    @Override
    public Mono<Project> saveProject(Project project) {
        return this.projectRepository.save(project);
    }
}
