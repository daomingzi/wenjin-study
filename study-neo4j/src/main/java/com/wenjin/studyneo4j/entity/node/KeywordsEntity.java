package com.wenjin.studyneo4j.entity.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Data
@Node("keywords")
public class KeywordsEntity {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    @Property("entity_id")
    private String entityId;

    @Property("entity_name")
    private String entityName;

    @Property("keywords")
    private String keywords;

    @Property("search_number")
    private Long searchNumber;

    @Property("create_time")
    private String createTime;

    @Property("update_time")
    private String updateTime;

}
