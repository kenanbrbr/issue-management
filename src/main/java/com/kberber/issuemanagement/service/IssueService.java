package com.kberber.issuemanagement.service;

import com.kberber.issuemanagement.dto.IssueDto;
import com.kberber.issuemanagement.entity.Issue;
import com.kberber.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);
}
