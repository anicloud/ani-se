package com.ani.se.es.dto;

import com.ani.se.es.entity.BasicSeEntity;

/**
 * Created by huangbin on 6/22/15.
 */
public abstract class BasicSeDto {
    public abstract void fromEntity(BasicSeEntity entity) throws Exception;
    public abstract BasicSeEntity toEntity() throws Exception;
}
