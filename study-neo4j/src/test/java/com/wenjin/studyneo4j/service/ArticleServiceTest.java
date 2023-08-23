package com.wenjin.studyneo4j.service;

import com.alibaba.fastjson.JSONObject;
import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import com.wenjin.studyneo4j.entity.relationship.RelTitleParagraph;
import com.wenjin.studyneo4j.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void queryArticleList() {
        articleService.queryArticleList();

    }

    @Test
    void updateArticle() {
        Optional<ArticleTitle> byId = articleRepository.findById("a5e62b4e-448d-42c2-883a-8c4c510f18b4");
        ArticleTitle articleTitle = byId.get();
        List<RelTitleParagraph> relTitleParagraphs = articleTitle.getRelTitleParagraphs();
        for (int i = 0; i < relTitleParagraphs.size(); i++) {
            int index = relTitleParagraphs.size() - i;
            System.out.println(index);
            relTitleParagraphs.get(i).setParagraphIndex(index);
        }
        articleTitle.setRelTitleParagraphs(relTitleParagraphs);
//        articleRepository.save(articleTitle);

        System.out.println(JSONObject.toJSONString(byId));
    }
}