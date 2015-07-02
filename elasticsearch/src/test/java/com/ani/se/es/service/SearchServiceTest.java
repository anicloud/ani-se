package com.ani.se.es.service;

import com.ani.se.es.dto.ApplicationSeDto;
import com.ani.se.es.dto.MasterSeDto;
import com.ani.se.es.dto.SlaveSeDto;
import com.ani.se.es.entity.ApplicationEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huangbin on 6/29/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/test/testApp.xml")
public class SearchServiceTest {
    private static final Logger log = LoggerFactory.getLogger(SearchServiceTest.class);
    @Resource
    SearchServiceImpl searchServiceImpl;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSearchDevice() throws Exception {
        List<MasterSeDto> masterSeDtoList = searchServiceImpl.searchDevice("air light");
        for (MasterSeDto masterSeDto : masterSeDtoList) {
            log.info(masterSeDto.toString());
        }
    }

    @Test
    public void testSearchApp() throws Exception {
        List<ApplicationSeDto> slaveSeDtoList = searchServiceImpl.searchApplication("智能");
        for (ApplicationSeDto applicationSeDto : slaveSeDtoList) {
            log.info(applicationSeDto.toString());
        }
    }


}