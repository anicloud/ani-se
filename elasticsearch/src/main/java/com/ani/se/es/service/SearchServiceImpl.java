package com.ani.se.es.service;

import com.ani.se.es.dto.ApplicationSeDto;
import com.ani.se.es.dto.BasicSeDto;
import com.ani.se.es.dto.MasterSeDto;
import com.ani.se.es.dto.SlaveSeDto;
import com.ani.se.es.entity.ApplicationEntity;
import com.ani.se.es.entity.BasicSeEntity;
import com.ani.se.es.entity.MasterEntity;
import com.ani.se.es.entity.SlaveEntity;
import com.ani.se.es.repository.ApplicationRepository;
import com.ani.se.es.repository.MasterRepository;
import com.ani.se.es.repository.SlaveRepository;
import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.hasChildQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * Created by huangbin on 6/22/15.
 */
@Component
public class SearchServiceImpl implements SearchService {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    private ApplicationRepository applicationRepository;

    @Resource
    private MasterRepository masterRepository;

    @Resource
    private SlaveRepository slaveRepository;

    public SearchServiceImpl() {

    }

    public void updateIndexDevice(MasterSeDto dto) throws Exception {
        MasterEntity masterEntity = dto.toMasterEntity();
        List<SlaveEntity> slaveEntities = dto.toSlaveEntity();
        masterRepository.index(masterEntity);
        for (SlaveEntity slaveEntity : slaveEntities) {
            slaveRepository.index(slaveEntity);
        }
    }

    public void updateIndexApplication(ApplicationSeDto dto) throws Exception {
        ApplicationEntity entity = dto.toEntity();
        applicationRepository.index(entity);
    }

    public void removeIndexDevice(MasterSeDto dto) throws Exception {
        MasterEntity masterEntity = dto.toMasterEntity();
        List<SlaveEntity> slaveEntities = dto.toSlaveEntity();
        for (SlaveEntity slaveEntity : slaveEntities) {
            slaveRepository.delete(slaveEntity);
        }
        masterRepository.delete(masterEntity);
    }

    public void removeIndexApplication(ApplicationSeDto dto) throws Exception {
        applicationRepository.delete(dto.toEntity());
    }

    public List<MasterSeDto> searchDevice(String query) throws Exception {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withIndices("anicloud").withTypes("slave")
                .withQuery(multiMatchQuery(query, "name", "description")).build();

        List<SlaveEntity> slaveEntityList = elasticsearchTemplate.queryForList(searchQuery, SlaveEntity.class);
        Map<String, MasterSeDto> map = new HashMap<String, MasterSeDto>();
        for (SlaveEntity slaveEntity : slaveEntityList) {
            if (!map.containsKey(slaveEntity.masterId)) {
                MasterEntity master = masterRepository.findOne(slaveEntity.masterId);
                if (master == null) {
                    continue;
                }
                List<SlaveEntity>  slaves = new ArrayList<SlaveEntity>();
                slaves.add(slaveEntity);
                map.put(slaveEntity.masterId, new MasterSeDto(master, slaves));
            } else {
                map.get(slaveEntity.masterId).slaves.add(new SlaveSeDto(slaveEntity));
            }
        }
        List<MasterSeDto> masterSeDtoList = new ArrayList<MasterSeDto>();
        for (Map.Entry<String, MasterSeDto> entry : map.entrySet()) {
            masterSeDtoList.add(entry.getValue());
        }
        return masterSeDtoList;
    }

    public List<ApplicationSeDto> searchApplication(String query) throws Exception {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withIndices("anicloud").withTypes("application")
                .withQuery(multiMatchQuery(query, "clientName", "description", "tags")).build();
        List<ApplicationEntity> applicationEntityList = elasticsearchTemplate.queryForList(searchQuery, ApplicationEntity.class);
        List<ApplicationSeDto> applicationSeDtoList = new ArrayList<ApplicationSeDto>();
        for (ApplicationEntity applicationEntity : applicationEntityList) {
            applicationSeDtoList.add(new ApplicationSeDto(applicationEntity));
        }

        return applicationSeDtoList;
    }
}
