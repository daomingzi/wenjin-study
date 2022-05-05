package com.wenjin.studyneo4j.entity.relationship;

import com.wenjin.studyneo4j.entity.node.ArticleParagraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * 文章和段落的链接
 * @author huangwj.
 * @date 2022/4/28
 */
@Data
@RelationshipProperties()
public class RelTitleParagraph {

    @RelationshipId
    @GeneratedValue
    private Long id;

    /**
     * 关系主键
     */
    @Property("rel_id")
    private String relId;
    /**
     * 关系名称
     */
    @Property("rel_type_name")
    private String relTypeName;
    /**
     * 段落位置索引, 默认是10的倍数, 比如第一段的索引是10, 第二段的索引是20
     */
    @Property("paragraph_index")
    private Integer paragraphIndex;
    /**
     * 创建时间
     */
    @Property("create_time")
    private String createTime;
    /**
     * 更新时间
     */
    @Property("update_time")
    private String updateTime;
    /**
     * 标签
     */
    @Property("tag")
    private String tag;

    @TargetNode
    private ArticleParagraph articleParagraph;

}
