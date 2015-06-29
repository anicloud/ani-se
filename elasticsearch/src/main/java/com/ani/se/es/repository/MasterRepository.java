package com.ani.se.es.repository;

import com.ani.se.es.entity.MasterEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by huangbin on 6/21/15.
 */
public interface MasterRepository extends ElasticsearchRepository<MasterEntity, String> {
}
