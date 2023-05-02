package com.lokesh.cloud.employee.service;

import com.lokesh.cloud.employee.entity.Domain;
import reactor.core.publisher.Mono;

public interface DomainService {

    Mono<Domain> saveDomain(Domain domain);
}
