package com.jioon.deploy_project.DTO;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Data
public class projectDTO {
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectUploadDate;
    private String projectTag;
    private int projectDownloadCount;
    private int projectViewCount;
    private byte[] projectDockerfile;
    private byte[] projectBuildfile;
    private String projectVersion;
    private String userId;
    private String projectStatus;
    @UpdateTimestamp
    @Column(name = "projectupdateddate")
    private LocalDateTime projectUpdatedDate;
    @CreationTimestamp
    @Column(name = "projectcreateddate")
    private LocalDateTime projectCreatedDate;
}
