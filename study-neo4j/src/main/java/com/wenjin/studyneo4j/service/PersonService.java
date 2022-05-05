package com.wenjin.studyneo4j.service;

import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import com.wenjin.studyneo4j.entity.node.PersonEntity;
import com.wenjin.studyneo4j.repository.ArticleRepository;
import com.wenjin.studyneo4j.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author huangwj.
 * @date 2022/4/26
 */

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private Neo4jClient neo4jClient;

    public void save(ArticleTitle articleTitle) {
        articleRepository.save(articleTitle);
    }

    public void delete(ArticleTitle articleTitle) {
        articleRepository.delete(articleTitle);
    }

    public void deleteAll() {
        articleRepository.deleteAll();


//        neo4jClient.getQueryRunner()

    }


}
