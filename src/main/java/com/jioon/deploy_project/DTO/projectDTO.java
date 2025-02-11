package com.jioon.deploy_project.DTO;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Data
public class projectDTO {
    private int projectId;
    private String projectName;
    private String projectDescription;
    @CreationTimestamp
    @Column(name = "projectUploadDate")
    private LocalDateTime projectUploadDate;
    private String projectTag;
    private int projectDownloadCount;
    private int projectViewCount;
    private String dfileName;
    private String bfileName;

    /* 
    private byte[] dockerfile;
    private byte[] buildfile;
    */
    private String projectVersion;
    private String userId;
    private String projectStatus;
    private boolean status;
    @UpdateTimestamp
    @Column(name = "projectupdateddate")
    private LocalDateTime projectUpdatedDate;
    
}
