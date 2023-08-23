package com.wenjin.studyneo4j.coponent;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.wenjin.studyneo4j.entity.node.ArticleParagraph;
import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import com.wenjin.studyneo4j.entity.relationship.RelTitleParagraph;
import com.wenjin.studyneo4j.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author huangwj.
 * @date 2022/5/10
 */

@Component
@Slf4j
public class ArticleUploadComponent {

    @Autowired
    private ArticleRepository articleRepository;

    public void uploadBatch(List<String> filePaths) {

        List<ArticleTitle> articleTitles = new ArrayList<>();
        for (String filePath : filePaths) {
            articleTitles.add(buildArticle(filePath));
        }
        long start = System.currentTimeMillis();
        List<ArticleTitle> results = articleRepository.saveAll(articleTitles);
        long end = System.currentTimeMillis();
//        results.forEach(result -> log.info("文章id: {}", result.getEntityId()));
        log.info("总耗时: {}", end - start);

    }


    public ArticleTitle buildArticle(String filePath) {
        FileReader fileReader = new FileReader(filePath);

        List<String> lines = fileReader.readLines();
        List<String> filterLines = lines.stream().filter(StrUtil::isNotBlank).collect(Collectors.toList());
        //        filterLines.forEach(System.out::println);

        ArticleTitle articleTitle = new ArticleTitle();
        List<RelTitleParagraph> rels = new ArrayList<>();
        for (int i = 0; i < filterLines.size(); i++) {
            if (i == 0) {
                buildArticleTitle(articleTitle, filterLines.get(i));
            } else {
                ArticleParagraph articleParagraph = buildParagraph(filterLines.get(i));
                RelTitleParagraph relTitleParagraph = buildRelTitleParagraph(i);
                relTitleParagraph.setArticleParagraph(articleParagraph);
                rels.add(relTitleParagraph);
            }
        }
        articleTitle.setRelTitleParagraphs(rels);
        log.info("构建文章数据: {}", JSONObject.toJSONString(articleTitle));

        return articleTitle;

    }

    private ArticleTitle buildArticleTitle(ArticleTitle articleTitle, String titleContent) {
        String now = DateUtil.now();
//        articleTitle.setEntityId("");
//        articleTitle.setEntityName("文章");
        articleTitle.setTitleContent(titleContent);
        articleTitle.setCreatTime(now);
        articleTitle.setUpdateTime(now);
        articleTitle.setSource("AI");
//        articleTitle.setBrief();
//        articleTitle.setPicId();
//        articleTitle.setPicUrl("");
//        articleTitle.setRelTitleParagraphs(Lists.newArrayList());
        return articleTitle;
    }

    private RelTitleParagraph buildRelTitleParagraph(int index) {
        String now = DateUtil.now();
        RelTitleParagraph rel = new RelTitleParagraph();
//        rel2.setId(1704L);
        rel.setRelId(UUID.randomUUID().toString());
//        rel.setRelTypeName("文章和段落的关系");
        rel.setParagraphIndex(index);
        rel.setCreateTime(now);
        rel.setUpdateTime(now);
//        rel.setTag();
//        rel.setArticleParagraph(paragraph2);
        return rel;
    }

    private ArticleParagraph buildParagraph(String paragraphContent) {

        String now = DateUtil.now();
        ArticleParagraph articleParagraph = new ArticleParagraph();
//        articleParagraph.setEntityId("");
//        articleParagraph.setEntityName("");
        articleParagraph.setParagraphContent(paragraphContent);
        articleParagraph.setCreatTime(now);
        articleParagraph.setUpdateTime(now);
//        articleParagraph.setUpdateUser();
//        articleParagraph.setTag("");

        return articleParagraph;
    }

}
