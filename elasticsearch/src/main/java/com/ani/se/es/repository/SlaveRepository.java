package com.ani.se.es.repository;

import com.ani.se.es.entity.SlaveEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by huangbin on 6/27/15.
 */
public interface SlaveRepository extends ElasticsearchRepository<SlaveEntity, String> {
    List<SlaveEntity> findByMasterId(String id);
    List<SlaveEntity> removeByMasterId(String id);
}
