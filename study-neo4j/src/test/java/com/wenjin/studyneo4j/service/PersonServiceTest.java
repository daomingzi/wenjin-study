package com.wenjin.studyneo4j.service;

import com.wenjin.studyneo4j.entity.node.ArticleParagraph;
import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import com.wenjin.studyneo4j.entity.relationship.RelTitleParagraph;
import com.wenjin.studyneo4j.repository.ArticleRepository;
import net.minidev.json.JSONUtil;
import org.assertj.core.util.Lists;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.ReactiveNeo4jClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private ArticleRepository articleRepository;


    @Autowired
    private Neo4jClient neo4jClient;




    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void create() {

        // ----------新建带关系的节点-------
//        List<ArticleTitle> articleTitles = new ArrayList<>();
//
//        ArticleParagraph articleParagraph = new ArticleParagraph("test段落id", "文章段落", "文章内容", "2022", "2022", "0000111");
//
////        ArrayList<ArticleParagraph> articleParagraphs = Lists.newArrayList(articleParagraph);
//        RelTitleParagraph rel = new RelTitleParagraph("关系id", "文章和段落的关系", 1, "2022", "2022", "这是一个tag");
//        rel.setArticleParagraph(articleParagraph);
//        ArrayList<RelTitleParagraph> rels = Lists.newArrayList(rel);
//
//        ArticleTitle articleTitle = new ArticleTitle("test1", "文章标题22222222", "test标题2", "2022-04-29", "20220429");
//        articleTitle.setRelTitleParagraphs(rels);
//
//
//        ArticleTitle save = articleRepository.save(articleTitle);
//        System.out.println(JSONObject.wrap(save));




        // 查询节点
//
        ArticleTitle articleTitle1 = articleRepository.queryArticle();
        System.out.println(JSONObject.wrap(articleTitle1));


//        Optional<ArticleTitle> byId = articleRepository.findById("9f0e7c8a-805c-4287-93f6-b45c3a63cbbb");
//        Optional<ArticleTitle> byId = articleRepository.findById("967");
//        System.out.println(byId);
//                personService.create();
    }
}