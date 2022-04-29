package com.wenjin.studyneo4j.repository;

import com.wenjin.studyneo4j.entity.node.PersonEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huangwj.
 * @description
 * @date 2022/4/29
 */

public interface PersonRepository extends Neo4jRepository<PersonEntity, Long> {
}
