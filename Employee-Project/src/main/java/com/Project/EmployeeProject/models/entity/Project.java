package com.Project.EmployeeProject.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    private Long id;
    @Column()
    private String name;
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();
}
