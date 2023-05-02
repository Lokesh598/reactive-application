package com.lokesh.cloud.employee.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "domain")
public class Domain {
    @Id
    private String id;
    @Field("domain_name")
    private String domainName;

    List<Project> projects;
    List<Employee> employees;
}
