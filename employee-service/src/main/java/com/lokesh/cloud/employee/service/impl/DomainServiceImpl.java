package com.lokesh.cloud.employee.service.impl;

import com.lokesh.cloud.employee.entity.Domain;
import com.lokesh.cloud.employee.repository.DomainRepository;
import com.lokesh.cloud.employee.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DomainServiceImpl implements DomainService {
    @Autowired
    DomainRepository domainRepository;
    @Override
    public Mono<Domain> saveDomain(Domain domain) {
        return this.domainRepository.save(domain);
    }
}
