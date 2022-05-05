package com.wenjin.studyneo4j.repository;

import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @author huangwj.
 * @date 2022/4/29
 */
public interface ArticleRepository extends Neo4jRepository<ArticleTitle, String> {

    @Query("match (n:article_title {entity_id:'test1'}) -[r]- (m) return n,collect(r),m")
    ArticleTitle queryArticle();

}
