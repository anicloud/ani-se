package com.ani.se.on.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * Created by huangbin on 6/21/15.
 */
@Document(indexName = "anicloud", type = "slave", shards = 1, replicas = 0)
public class SlaveEntity extends BasicSeEntity {
    @Id
    public String id;

    @Field(
            type = FieldType.String,
            index = FieldIndex.no
    )
    public String deviceId;

    @Field(
            type = FieldType.String,
            index = FieldIndex.not_analyzed,
            store = true
    )
    @Parent(type = "master")
    public String masterId;

    @Field(
            type = FieldType.String,
            index = FieldIndex.analyzed,
            indexAnalyzer = "ik", searchAnalyzer = "ik"
    )
    public String name;

    @Field(
            type = FieldType.String,
            index = FieldIndex.analyzed,
            indexAnalyzer = "ik", searchAnalyzer = "ik"
    )
    public String description;

    @Field(
            type = FieldType.String,
            index = FieldIndex.no
    )
    public String physicalId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(String physicalId) {
        this.physicalId = physicalId;
    }
}

