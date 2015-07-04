package com.ani.se.on.dto;

import com.ani.se.on.entity.ApplicationEntity;

import java.util.Date;

/**
 * Created by huangbin on 6/22/15.
 */
public class ApplicationSeDto {
//    Application information
    public String clientId;
    public String clientName;
    public String description;
    public String tags;
    public String language;
    public Date createTime;

//    Developer information
    public String developerName;
    public String developerEmail;

    public ApplicationSeDto() {
    }

    public ApplicationSeDto(ApplicationEntity entity) throws Exception {
        clientId = entity.clientId;
        clientName = entity.clientName;
        description = entity.description;
        tags = entity.tags;
        language = entity.language;
        createTime = entity.createTime;
        developerName = entity.developerName;
        developerEmail = entity.developerEmail;
    }

    public void fromEntity(ApplicationEntity entity) throws Exception {
        clientId = entity.clientId;
        clientName = entity.clientName;
        description = entity.description;
        tags = entity.tags;
        language = entity.language;
        createTime = entity.createTime;
        developerName = entity.developerName;
        developerEmail = entity.developerEmail;
    }


    public ApplicationEntity toEntity() throws Exception {
        ApplicationEntity entity = new ApplicationEntity();
        entity.clientId = clientId;
        entity.clientName = clientName;
        entity.description = description;
        entity.tags = tags;
        entity.language = language;
        entity.createTime = createTime;
        entity.developerName = developerName;
        entity.developerEmail = developerEmail;
        return entity;
    }

    @Override
    public String toString() {
        return "ApplicationSeDto{" +
                "clientId='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", language='" + language + '\'' +
                ", createTime=" + createTime +
                ", developerName='" + developerName + '\'' +
                ", developerEmail='" + developerEmail + '\'' +
                '}';
    }
}
