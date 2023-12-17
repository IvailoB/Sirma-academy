package com.Project.EmployeeProject.services;

import com.Project.EmployeeProject.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

}
