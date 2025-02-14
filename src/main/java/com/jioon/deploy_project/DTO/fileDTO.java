package com.jioon.deploy_project.DTO;

import lombok.Data;

@Data
public class fileDTO {
    private String userId;
    private String projectName;
    private byte[] dockerFile;
    private String dfileName;
    private byte[] buildFile;
    private String bfileName;
}
