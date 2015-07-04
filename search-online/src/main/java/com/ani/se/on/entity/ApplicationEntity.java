package com.ani.se.on.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;

/**
 * Created by huangbin on 6/21/15.
 */
@Document(indexName = "anicloud", type = "application", shards = 1, replicas = 0)
public class ApplicationEntity extends BasicSeEntity{
//    Application information
    @Id
    public String clientId;

    @Field(
            index = FieldIndex.analyzed,
            type = FieldType.String,
            indexAnalyzer = "ik", searchAnalyzer = "ik"
    )
    public String clientName;

    @Field(index = FieldIndex.analyzed,
            type = FieldType.String,
            indexAnalyzer = "ik", searchAnalyzer = "ik"
    )
    public String description;

    @Field(index = FieldIndex.analyzed,
            type = FieldType.String,
            indexAnalyzer = "ik", searchAnalyzer = "ik"
    )
    public String tags;

    @Field(index = FieldIndex.not_analyzed,
            type = FieldType.String
    )

    public String language;

    @Field(
            index = FieldIndex.not_analyzed,
            type = FieldType.Date,
            format = DateFormat.custom, pattern = "dd.MM.yyyy hh:mm:ss"
    )
    public Date createTime;

//    Developer information

    @Field(index = FieldIndex.analyzed,
            type = FieldType.String,
            indexAnalyzer = "ik", searchAnalyzer = "ik"
    )
    public String developerName;

    @Field(index = FieldIndex.not_analyzed,
            type = FieldType.String)
    public String developerEmail;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }
}
