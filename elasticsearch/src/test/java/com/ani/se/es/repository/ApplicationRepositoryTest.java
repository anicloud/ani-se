package com.ani.se.es.repository;

import com.ani.se.es.entity.ApplicationEntity;

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

import static org.junit.Assert.*;

/**
 * Created by huangbin on 6/22/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context/app.xml")
public class ApplicationRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(ApplicationRepositoryTest.class);
    @Resource
    ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    ApplicationRepository applicationRepository;

    @Before
    public void setUp() throws Exception {
        String indexName = "anicloud";
        elasticsearchTemplate.deleteIndex(indexName);
        if (!elasticsearchTemplate.indexExists(indexName)) {
            elasticsearchTemplate.createIndex(indexName);
        }
        elasticsearchTemplate.putMapping(ApplicationEntity.class);
        elasticsearchTemplate.refresh(ApplicationEntity.class, true);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testApplicationIndex() throws Exception {
        applicationRepository.deleteAll();
        ApplicationEntity entity = new ApplicationEntity();
        entity.clientId = "123456id";
        entity.clientName = "智能灯";
        entity.language = "chs";
        entity.description = "这是一个智能灯的应用";
        entity.tags = "智能灯";
        entity.developerName = "黄斌";
        entity.developerEmail = "fantasyhb@gmail.com";
        ApplicationEntity indexedEntity =  applicationRepository.index(entity);
        log.info("indexed app id: " + indexedEntity.clientId);
    }
}