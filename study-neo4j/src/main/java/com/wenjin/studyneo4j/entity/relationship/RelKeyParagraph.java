package com.wenjin.studyneo4j.entity.relationship;

import com.wenjin.studyneo4j.entity.node.ArticleParagraph;
import com.wenjin.studyneo4j.entity.node.KeywordsEntity;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

@Data
@RelationshipProperties
@Node("K")
public class RelKeyParagraph {
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
    private KeywordsEntity keywordsEntity;

}
