package com.ani.se.es.entity;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Created by huangbin on 6/21/15.
 */
public class FunctionEntity extends BasicSeEntity {
    //    Group information
    @Field(index = FieldIndex.analyzed,
            type = FieldType.String,
            indexAnalyzer = "ik", searchAnalyzer = "ik",
            store = true
    )
    public String groupName;

    @Field(index = FieldIndex.not_analyzed,
            type = FieldType.String)
    public String groupPrivacy;

    //    Function information
    @Field(index = FieldIndex.not_analyzed,
            type = FieldType.String)
    public String type;

    @Field(index = FieldIndex.analyzed,
            type = FieldType.String,
            indexAnalyzer = "ik", searchAnalyzer = "ik",
            store = true
    )
    public String name;

    @Field(index = FieldIndex.not_analyzed,
            type = FieldType.String)
    public String privacy;

}
