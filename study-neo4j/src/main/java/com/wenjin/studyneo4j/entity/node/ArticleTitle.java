package com.wenjin.studyneo4j.entity.node;

import com.wenjin.studyneo4j.entity.relationship.RelTitleParagraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;

/**
 * @author huangwj.
 * @date 2022/4/28
 */

@Node("article_title")
@Data
@NoArgsConstructor
public class ArticleTitle {
    /**
     * 实体类id
     */
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    @Property("entity_id")
    private String entityId;
    /**
     * 实体类名称
     */
    @Property("entity_name")
    private String entityName;
    /**
     * 标题内容
     */
    @Property("title_content")
    private String titleContent;
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


//    @Relationship(type = "rel_title_paragraph", direction = Relationship.Direction.OUTGOING)
//    private List<ArticleParagraph> paragraphs;


    public ArticleTitle(String entityId, String entityName, String titleContent, String creatTime, String updateTime) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.titleContent = titleContent;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    @Relationship(type = "rel_title_paragraph", direction = Relationship.Direction.OUTGOING)
    private List<RelTitleParagraph> relTitleParagraphs;

}
