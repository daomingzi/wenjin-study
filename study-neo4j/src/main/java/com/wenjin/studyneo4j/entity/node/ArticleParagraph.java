package com.wenjin.studyneo4j.entity.node;

import com.wenjin.studyneo4j.entity.relationship.RelKeyParagraph;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;

/**
 * @author huangwj.
 * @date 2022/4/28
 */

@Data
@Node("article_paragraph")
public class ArticleParagraph {
    /**
     * 段落主键
     */
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    @Property("entity_id")
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
    @Property("tag")
    private String tag;

    @Relationship(type = "rel_title_paragraph", direction = Relationship.Direction.INCOMING)
    private List<RelKeyParagraph> relKeyParagraphs;


}
