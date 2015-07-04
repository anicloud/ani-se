package com.ani.se.on.dto;

import com.ani.se.on.entity.BasicSeEntity;
import com.ani.se.on.entity.FunctionEntity;

/**
 * Created by huangbin on 6/22/15.
 */
public class FunctionSeDto extends BasicSeDto{
    //    Group information
    public String groupName;
    public String groupPrivacy;

    //    Function information
    public String name;
    public String privacy;
    public String type;

    @Override
    public void fromEntity(BasicSeEntity entity) throws Exception {
        FunctionEntity functionEntity = (FunctionEntity)entity;
        groupName = functionEntity.groupName;
        groupPrivacy = functionEntity.groupPrivacy;
        name = functionEntity.name;
        privacy = functionEntity.privacy;
        type = functionEntity.type;
    }

    @Override
    public BasicSeEntity toEntity() throws Exception {
        FunctionEntity entity = new FunctionEntity();
        entity.groupName = groupName;
        entity.groupPrivacy = groupPrivacy;
        entity.name = name;
        entity.privacy = privacy;
        entity.type = type;
        return entity;
    }

}
