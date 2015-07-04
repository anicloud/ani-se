package com.ani.se.on.service;

import com.ani.cel.device.manager.core.domain.ObjectState;
import com.ani.cel.device.manager.core.domain.device.DeviceMaster;
import com.ani.cel.device.manager.core.domain.device.DeviceSlave;
import com.ani.se.on.dto.MasterSeDto;
import com.ani.se.on.dto.SlaveSeDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangbin on 7/2/15.
 */
@Component("deviceIndexService")
public class DeviceIndexService {
    @Resource
    SearchService searchService;

    private SlaveSeDto convertToSlaveSeDto(String masterId, DeviceSlave deviceSlave) {
        if (masterId == null || deviceSlave == null) {
            return null;
        }
        SlaveSeDto slaveSeDto = new SlaveSeDto();
        slaveSeDto.deviceId = deviceSlave.deviceId;
        slaveSeDto.name = deviceSlave.name;
        slaveSeDto.description = deviceSlave.description;
        slaveSeDto.physicalId = deviceSlave.physicalId;
        slaveSeDto.masterId = masterId;
        return slaveSeDto;
    }

    private MasterSeDto convertToMasterSeDto(DeviceMaster deviceMaster) {
        if (deviceMaster == null) {
            return null;
        }
        List<SlaveSeDto> slaveSeDtoList = new ArrayList<SlaveSeDto>();
        if (deviceMaster.slaves != null) {
            for (DeviceSlave deviceSlave : deviceMaster.slaves) {
                slaveSeDtoList.add(convertToSlaveSeDto(deviceMaster.deviceId, deviceSlave));
            }
        }
        MasterSeDto masterSeDto = new MasterSeDto();
        masterSeDto.deviceId = deviceMaster.deviceId;
        masterSeDto.name = deviceMaster.name;
        masterSeDto.description = deviceMaster.description;
        masterSeDto.physicalId = deviceMaster.physicalId;
        masterSeDto.physicalAddress = deviceMaster.physicalAddress;
        masterSeDto.slaves = slaveSeDtoList;

        if (deviceMaster.objectState == ObjectState.REMOVED) {
            masterSeDto.removed = true;
        }
        return masterSeDto;
    }

    public void updateDeviceIndex(DeviceMaster deviceMaster) {
        try {
            searchService.updateIndexDevice(convertToMasterSeDto(deviceMaster));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
