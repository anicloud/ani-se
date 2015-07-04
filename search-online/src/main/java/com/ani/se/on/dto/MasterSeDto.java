package com.ani.se.on.dto;

import com.ani.se.on.entity.MasterEntity;
import com.ani.se.on.entity.SlaveEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangbin on 6/22/15.
 */
public class MasterSeDto {
    public String type; // master or slave device
    public String deviceId;
    public String name;
    public String description;

    public String physicalId;
    public String physicalAddress;

    public List<SlaveSeDto> slaves = new ArrayList<SlaveSeDto>();

    public boolean removed = false;

    public MasterSeDto() {
    }

    public MasterSeDto(MasterEntity masterEntity, List<SlaveEntity> slaveEntities) {
        deviceId = masterEntity.deviceId;
        name = masterEntity.name;
        description = masterEntity.description;
        physicalId = masterEntity.physicalId;
        physicalAddress = masterEntity.physicalAddress;
        slaves.clear();
        if (slaveEntities != null) {
            for (SlaveEntity slaveEntity : slaveEntities) {
                slaves.add(new SlaveSeDto(slaveEntity));
            }
        }
    }

    public void fromEntity(MasterEntity masterEntity, List<SlaveEntity> slaveEntities) {
        deviceId = masterEntity.deviceId;
        name = masterEntity.name;
        description = masterEntity.description;
        physicalId = masterEntity.physicalId;
        physicalAddress = masterEntity.physicalAddress;
        slaves.clear();
        if (slaveEntities != null) {
            for (SlaveEntity slaveEntity : slaveEntities) {
                slaves.add(new SlaveSeDto(slaveEntity));
            }
        }
    }

    public MasterEntity toMasterEntity() {
        MasterEntity entity = new MasterEntity();
        entity.deviceId = deviceId;
        entity.name = name;
        entity.description = description;
        entity.physicalId = physicalId;
        entity.physicalAddress = physicalAddress;
        return entity;
    }

    public List<SlaveEntity> toSlaveEntityList() {
        List<SlaveEntity> slaveEntities = new ArrayList<SlaveEntity>();
        for (SlaveSeDto slaveSeDto : slaves) {
            slaveEntities.add(slaveSeDto.toEntity());
        }
        return slaveEntities;
    }

    @Override
    public String toString() {
        String strSlaves = "";
        for (SlaveSeDto slaveSeDto : slaves) {
            strSlaves += "\n" + slaveSeDto.toString();
        }
        return "MasterSeDto{" +
                "physicalAddress='" + physicalAddress + '\'' +
                ", physicalId='" + physicalId + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", type='" + type + '\'' +
                ", slaves=" + strSlaves +
                '}';
    }
}
