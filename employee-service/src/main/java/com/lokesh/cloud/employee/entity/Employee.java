package com.lokesh.cloud.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    @Field("employee_name")
    private String name;
//    @JsonProperty("ROLE")
    @Field("role")
    private String role;
    @Field("time_zone")
    private String TIMEZONE;
    @Field("employee_belongs_to")
    private String employeeBelongsTo;
    @Field("nisum_email_id")
    private String nisumEmailId;
    @Field("client_email_id")
    private String clientEmailId;
    @Field("contact")
    @JsonProperty("Contact")
    private String contact;
    @Field("account_id")
    private String accountId;
    @Field("domain_id")
    private String domainId;
    @Field("project_id")
    private String projectId;
}
