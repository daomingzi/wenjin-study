package com.wenjin.studyneo4j.repository;


import com.wenjin.studyneo4j.entity.node.ArticleParagraph;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ParagraphRepository extends Neo4jRepository<ArticleParagraph, String> {
}
