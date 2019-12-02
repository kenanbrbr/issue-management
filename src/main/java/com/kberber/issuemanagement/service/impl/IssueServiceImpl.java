package com.kberber.issuemanagement.service.impl;

import com.kberber.issuemanagement.dto.IssueDto;
import com.kberber.issuemanagement.entity.Issue;
import com.kberber.issuemanagement.repository.IssueRepository;
import com.kberber.issuemanagement.service.IssueService;
import com.kberber.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper){

        this.issueRepository = issueRepository;
        this.modelMapper=modelMapper;

    }

    public IssueServiceImpl(){
        super();
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate()==null){
            throw new IllegalArgumentException("Issue Date cannot be null!");
        }

        Issue issueDb =  modelMapper.map(issue, Issue.class);

        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data =  issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos =  modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }

}
