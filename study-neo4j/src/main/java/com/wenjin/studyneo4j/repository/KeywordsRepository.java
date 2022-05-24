package com.wenjin.studyneo4j.repository;

import com.wenjin.studyneo4j.entity.node.KeywordsEntity;
import com.wenjin.studyneo4j.entity.node.PersonEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huangwj.
 * @description
 * @date 2022/4/29
 */
@Repository
public interface KeywordsRepository extends Neo4jRepository<KeywordsEntity, String> {
}
