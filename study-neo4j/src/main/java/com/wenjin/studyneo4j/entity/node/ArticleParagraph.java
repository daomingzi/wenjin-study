package com.wenjin.studyneo4j.entity.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neo4j.cypherdsl.core.Neo4jVersion;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * @author huangwj.
 * @date 2022/4/28
 */

@Node("article_paragraph")
@Data
@AllArgsConstructor
public class ArticleParagraph {

    /**
     * 段落主键
     */
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String entityId;
    /**
     * 节点名称
     */
    @Property("entity_name")
    private String entityName;
    /**
     * 段落内容
     */
    @Property("paragraph_content")
    private String paragraphContent;
    /**
     * 创建时间
     */
    @Property("creat_time")
    private String creatTime;
    /**
     * 更新时间
     */
    @Property("update_time")
    private String updateTime;
    /**
     * 更新人
     */
    @Property("update_user")
    private String updateUser;
    /**
     * 标签
     */
//    @Property("tag")
//    private String tag;

}
