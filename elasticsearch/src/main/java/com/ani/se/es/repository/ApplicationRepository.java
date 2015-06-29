package com.ani.se.es.repository;

import com.ani.se.es.entity.ApplicationEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by huangbin on 6/21/15.
 */
public interface ApplicationRepository extends ElasticsearchRepository<ApplicationEntity, String> {
}
