package com.ani.se.on.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * Created by huangbin on 6/22/15.
 */
@Document(indexName = "anicloud", type = "master", shards = 1, replicas = 0)
public class MasterEntity extends BasicSeEntity {
    @Id
    public String deviceId;

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

    @Field(
            type = FieldType.String,
            index = FieldIndex.no
    )
    public String physicalAddress;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
