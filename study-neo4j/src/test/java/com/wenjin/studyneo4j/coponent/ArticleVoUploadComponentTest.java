package com.wenjin.studyneo4j.coponent;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ArticleVoUploadComponentTest {

    @Autowired
    private ArticleUploadComponent articleUploadComponent;

    private static final List<String> filePaths;

    static {
        filePaths = Lists.newArrayList(
                "/Users/gavin/Documents/sunline/new220509/article6.txt"
        );
    }

    @Test
    public void upload() {
        articleUploadComponent.uploadBatch(filePaths);
    }

}