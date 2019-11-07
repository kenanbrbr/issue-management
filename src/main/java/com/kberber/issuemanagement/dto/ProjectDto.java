package com.kberber.issuemanagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProjectDto {

    private Long id;
    private String projectName;
    private String projectCode;
}
