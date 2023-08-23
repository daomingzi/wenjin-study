package com.wenjin.studyneo4j.service;

import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import com.wenjin.studyneo4j.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author huangwj.
 * @date 2022/5/24
 */
@Service
@AllArgsConstructor
@Slf4j
public class ArticleService {

    private final ArticleRepository articleRepository;

    public String queryArticleList() {

        int count=100;
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Optional<ArticleTitle> byId = articleRepository.findById("c9a7a0af-eb89-4705-9fd8-42ebe398459a.txt");
        }
        long end = System.currentTimeMillis();

        log.info("查询{}次, 耗时: {}毫秒", count, end-start);
        return null;

    }

}
