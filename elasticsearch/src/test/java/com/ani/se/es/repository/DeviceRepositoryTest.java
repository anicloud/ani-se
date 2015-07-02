package com.ani.se.es.repository;

import com.ani.se.es.entity.MasterEntity;
import com.ani.se.es.entity.FunctionEntity;
import com.ani.se.es.entity.SlaveEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;

/**
 * Created by huangbin on 6/22/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/test/testApp.xml")
public class DeviceRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(DeviceRepositoryTest.class);
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    private MasterRepository masterRepository;

    @Resource
    private SlaveRepository slaveRepository;

    @Before
    public void setUp() throws Exception {
        String indexName = "anicloud";
        if (!elasticsearchTemplate.indexExists(indexName)) {
            elasticsearchTemplate.createIndex(indexName);
        }
        elasticsearchTemplate.putMapping(MasterEntity.class);
        elasticsearchTemplate.refresh(MasterEntity.class, true);
        elasticsearchTemplate.putMapping(SlaveEntity.class);
        elasticsearchTemplate.refresh(SlaveEntity.class, true);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDeviceIndex() throws Exception {
        masterRepository.deleteAll();
        slaveRepository.deleteAll();

        MasterEntity masterEntity = new MasterEntity();
        masterEntity.deviceId = "123456id";
        masterEntity.name = "主设备";
        masterEntity.description = "这是一个主设备";
        masterEntity.physicalId = "32123434";
        masterEntity.physicalAddress = "12:34:56:78:90";

        MasterEntity masterEntity2 = new MasterEntity();
        masterEntity2.deviceId = "123457id";
        masterEntity2.name = "主设备2";
        masterEntity2.description = "这是第二个主设备";
        masterEntity2.physicalId = "32123434";
        masterEntity2.physicalAddress = "12:34:56:78:90";


//        Slave definition
        SlaveEntity slaveEntity = new SlaveEntity();
        slaveEntity.deviceId = "123456slaveId";
        slaveEntity.name = "智能灯";
        slaveEntity.description = "这是一个智能灯的从设备";
        slaveEntity.physicalId = "32423432";

        slaveEntity.masterId = masterEntity.deviceId;
        slaveEntity.id = masterEntity.deviceId + slaveEntity.deviceId;

        masterRepository.index(masterEntity);
        masterRepository.index(masterEntity2);
        slaveRepository.index(slaveEntity);

//        masterRepository.delete(masterEntity);
//
//        FunctionEntity functionOn = new FunctionEntity();
//        functionOn.groupPrivacy = "公有";
//        functionOn.groupName = "灯";
//        functionOn.name = "打开";
//        functionOn.privacy = "公有";
//        functionOn.type = "同步";
//
//        FunctionEntity functionOff = new FunctionEntity();
//        functionOff.groupPrivacy = "公有";
//        functionOff.groupName = "灯";
//        functionOff.name = "关闭";
//        functionOff.privacy = "公有";
//        functionOff.type = "同步";

//        deviceRepository.deleteByDeviceId(entity.deviceId);
    }
}