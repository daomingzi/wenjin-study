package com.wenjin.studyneo4j.repository;

import com.wenjin.studyneo4j.entity.ArticleVo;
import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.util.Streamable;

import java.util.List;

/**
 * @author huangwj.
 * @date 2022/4/29
 */
public interface ArticleRepository extends Neo4jRepository<ArticleTitle, String> {

    /**
     * 根据名称模糊查询
     * @author huangwj.
     * @date 2022/5/24 4:17 下午
     * @param articleName articleName
     * @param source source
     */
    List<ArticleVo> findArticleTitlesByEntityNameLikeAndSourceLike(String articleName, String source);



}
