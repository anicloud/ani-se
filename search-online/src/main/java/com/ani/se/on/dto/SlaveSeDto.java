package com.ani.se.on.dto;

import com.ani.se.on.entity.SlaveEntity;

/**
 * Created by huangbin on 6/23/15.
 */
public class SlaveSeDto {
    public String masterId;
    public String deviceId;
    public String name;
    public String description;
    public String physicalId;

    public SlaveSeDto() {
    }

    public SlaveSeDto(SlaveEntity slaveEntity) {
        masterId = slaveEntity.masterId;
        deviceId = slaveEntity.deviceId;
        description = slaveEntity.description;
        name = slaveEntity.name;
        physicalId = slaveEntity.physicalId;
    }

    public void fromEntity(SlaveEntity slaveEntity) {
        masterId = slaveEntity.masterId;
        deviceId = slaveEntity.deviceId;
        description = slaveEntity.description;
        name = slaveEntity.name;
        physicalId = slaveEntity.physicalId;
    }

    public SlaveEntity toEntity() {
        SlaveEntity entity = new SlaveEntity();
        entity.id = masterId + deviceId;
        entity.masterId = masterId;
        entity.deviceId = deviceId;
        entity.name = name;
        entity.description = description;
        entity.physicalId = physicalId;
        return entity;
    }

    @Override
    public String toString() {
        return "SlaveSeDto{" +
                "masterId='" + masterId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", physicalId='" + physicalId + '\'' +
                '}';
    }
}
