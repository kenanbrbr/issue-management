package com.kberber.issuemanagement.service.impl;

import com.kberber.issuemanagement.entity.Project;
import com.kberber.issuemanagement.repository.ProjectRepository;
import com.kberber.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){

        this.projectRepository = projectRepository;

    }

    @Override
    public Project save(Project project) {
        if(project.getProjectCode() == null){
            throw new IllegalArgumentException("Project code can not be null!");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
