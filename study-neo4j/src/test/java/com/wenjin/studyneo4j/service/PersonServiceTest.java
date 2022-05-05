package com.wenjin.studyneo4j.service;
import com.wenjin.studyneo4j.entity.node.KeywordsEntity;

import com.alibaba.fastjson.JSONObject;
import com.wenjin.studyneo4j.entity.node.ArticleParagraph;
import com.wenjin.studyneo4j.entity.node.ArticleTitle;
import com.wenjin.studyneo4j.entity.relationship.RelKeyParagraph;
import com.wenjin.studyneo4j.entity.relationship.RelTitleParagraph;
import com.wenjin.studyneo4j.repository.ArticleRepository;
import com.wenjin.studyneo4j.repository.ParagraphRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.neo4j.driver.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ParagraphRepository paragraphRepository;


    @Autowired
    private Neo4jClient neo4jClient;




    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private List<RelKeyParagraph> createRel(int num) {
        List<RelKeyParagraph> relKeyParagraphs = new ArrayList<>();

        KeywordsEntity keywordsEntity1 = new KeywordsEntity();
//        keywordsEntity.setEntityId("");
        keywordsEntity1.setEntityName("搜索关键词" + num);
        keywordsEntity1.setKeywords("关键词" + num);
        keywordsEntity1.setSearchNumber(100L);
        keywordsEntity1.setCreateTime("2022-04-30 00:00:00");
        keywordsEntity1.setUpdateTime("2022-04-30 00:00:00");

        RelKeyParagraph relKeyParagraph1 = new RelKeyParagraph();
//        relKeyParagraph.setId(0L);
        relKeyParagraph1.setRelId("relid222222");
        relKeyParagraph1.setRelTypeName("搜索词链接段落");
        relKeyParagraph1.setCreateTime("2022-04-30 00:00:00");
        relKeyParagraph1.setUpdateTime("2022-04-30 00:00:00");
        relKeyParagraph1.setTag("标签" +num);
        relKeyParagraph1.setKeywordsEntity(keywordsEntity1);

        KeywordsEntity keywordsEntity2 = new KeywordsEntity();
//        keywordsEntity.setEntityId("");
        keywordsEntity2.setEntityName("搜索关键词" + num*10);
        keywordsEntity2.setKeywords("关键词" + num*10);
        keywordsEntity2.setSearchNumber(100L);
        keywordsEntity2.setCreateTime("2022-04-30 00:00:00");
        keywordsEntity2.setUpdateTime("2022-04-30 00:00:00");

        RelKeyParagraph relKeyParagraph2 = new RelKeyParagraph();
//        relKeyParagraph.setId(0L);
        relKeyParagraph2.setRelId("relid222222");
        relKeyParagraph2.setRelTypeName("搜索词链接段落");
        relKeyParagraph2.setCreateTime("2022-04-30 00:00:00");
        relKeyParagraph2.setUpdateTime("2022-04-30 00:00:00");
        relKeyParagraph2.setTag("标签" +num);
        relKeyParagraph2.setKeywordsEntity(keywordsEntity2);

        relKeyParagraphs.add(relKeyParagraph1);
        relKeyParagraphs.add(relKeyParagraph2);

        return relKeyParagraphs;
    }

    @Test
//    @Transactional("neo4jTransactionManager")
    public void create() {

        // ----------新建带关系的节点-------
        List<ArticleTitle> articleTitles = new ArrayList<>();

        ArticleParagraph paragraph1 = new ArticleParagraph();
//        paragraph1.setEntityId("66483225-1f89-4919-b8bb-3ea0f87de0da");
        paragraph1.setEntityName("文章段落_修改");
        paragraph1.setParagraphContent("时间从2020年的初春一路蹒跚到繁花似锦、绿树蓊郁的仲夏，清风吹过，我听见回 响一来自山谷和心间。在那动人的回响中，青春的呐喊犹如雏凤的啼鸣一清脆而悦 耳；在那美丽的土地上，一张张青春的面孔犹如盛开的夏花一明艳而璀璨。");
        paragraph1.setCreatTime("2022-04-30 00:00:00");
        paragraph1.setUpdateTime("2022-04-30 00:00:00");
        paragraph1.setUpdateUser("admin");
        paragraph1.setTag("高考满分作文");
        paragraph1.setRelKeyParagraphs(createRel(1));

        ArticleParagraph paragraph2 = new ArticleParagraph();
//        paragraph2.setEntityId("66e5108f-ae62-449c-8394-f8cb7ca8ab82");
        paragraph2.setEntityName("文章段落_修改");
        paragraph2.setParagraphContent("那些青春的面孔啊，“承受着心跳的负荷和呼吸的累赘却乐此不疲”，那是2020年的 “中国面孔”。");
        paragraph2.setCreatTime("2022-04-30 00:00:00");
        paragraph2.setUpdateTime("2022-04-30 00:00:00");
        paragraph2.setUpdateUser("admin");
        paragraph2.setTag("高考满分作文");
        paragraph2.setRelKeyParagraphs(createRel(2));

        ArticleParagraph paragraph3 = new ArticleParagraph();
//        paragraph3.setEntityId("b072f775-9212-4acb-b8eb-15554bd60a5d");
        paragraph3.setEntityName("文章段落_修改");
        paragraph3.setParagraphContent("疫情如山，在沉重的大山阻隔了生的希望带来了死的恐惧之时，我看到了沿国道走了\n" +
                "一天一夜，步行110公里，年仅18岁的朱如归那张有着逆行武汉的勇气的面孔。医院就是 战场，在武汉客厅方舱医院，在厚重的防护服包裹下，我看到了口罩、护目镜后面00后 刘佳怡那张疲惫而坚定的面孔。还有，95后甘如意、26岁志愿者吴悠志、29岁彭银 华.他们有着不同的名字，但他们又有着同样坚定的青春面孔！他们年纪不大，却用一 段青春描绘了华夏的动人画卷！华夏有你，笃志的青年，明日之华夏定当繁荣美丽！你生\n" +
                "在华夏，以民为本的华夏，未来之你们定当乘风远航！");
        paragraph3.setCreatTime("2022-04-30 00:00:00");
        paragraph3.setUpdateTime("2022-04-30 00:00:00");
        paragraph3.setUpdateUser("admin");
        paragraph3.setTag("高考满分作文");
        paragraph3.setRelKeyParagraphs(createRel(3));

        ArticleParagraph paragraph4 = new ArticleParagraph();
//        paragraph4.setEntityId("41d129c2-4ea1-4870-945e-252a372720ce");
        paragraph4.setEntityName("文章段落_修改");
        paragraph4.setParagraphContent("那些青春的面孔啊，“以寂寞的镰刀”收割着人生的丰盈，不凋不败，不骄不馁，那是2020年的“中国面孔”。");
        paragraph4.setCreatTime("2022-04-30 00:00:00");
        paragraph4.setUpdateTime("2022-04-30 00:00:00");
        paragraph4.setUpdateUser("admin");
        paragraph4.setTag("高考满分作文");
        paragraph4.setRelKeyParagraphs(createRel(4));


        ArrayList<ArticleParagraph> paragraphs = Lists.newArrayList();
        paragraphs.add(paragraph1);
        paragraphs.add(paragraph2);
        paragraphs.add(paragraph3);
        paragraphs.add(paragraph4);

        RelTitleParagraph rel1 = new RelTitleParagraph();
        rel1.setId(null);
        rel1.setRelId("uuid1111");
        rel1.setRelTypeName("文章和段落的关系");
        rel1.setParagraphIndex(1);
        rel1.setCreateTime("2022-04-30 00:00:00");
        rel1.setUpdateTime("2022-04-30 00:00:00");
        rel1.setTag("链接高考满分作文");
        rel1.setArticleParagraph(paragraph1);

        RelTitleParagraph rel2 = new RelTitleParagraph();
        rel2.setId(null);
        rel2.setRelId("uuid1111");
        rel2.setRelTypeName("文章和段落的关系");
        rel2.setParagraphIndex(2);
        rel2.setCreateTime("2022-04-30 00:00:00");
        rel2.setUpdateTime("2022-04-30 00:00:00");
        rel2.setTag("链接高考满分作文");
        rel2.setArticleParagraph(paragraph2);

        RelTitleParagraph rel3 = new RelTitleParagraph();
        rel3.setId(null);
        rel3.setRelId("uuid1111");
        rel3.setRelTypeName("文章和段落的关系");
        rel3.setParagraphIndex(3);
        rel3.setCreateTime("2022-04-30 00:00:00");
        rel3.setUpdateTime("2022-04-30 00:00:00");
        rel3.setTag("链接高考满分作文");
        rel3.setArticleParagraph(paragraph3);

        RelTitleParagraph rel4 = new RelTitleParagraph();
        rel4.setId(null);
        rel4.setRelId("uuid1111");
        rel4.setRelTypeName("文章和段落的关系");
        rel4.setParagraphIndex(4);
        rel4.setCreateTime("2022-04-30 00:00:00");
        rel4.setUpdateTime("2022-04-30 00:00:00");
        rel4.setTag("链接高考满分作文");
        rel4.setArticleParagraph(paragraph4);

        List<RelTitleParagraph> rels = Lists.newArrayList();
        rels.add(rel1);
        rels.add(rel2);
        rels.add(rel3);
        rels.add(rel4);


        ArticleTitle articleTitle = new ArticleTitle();
//        articleTitle.setEntityId("4322011a-26bc-4eec-9508-3bd2b3dffaa9");
        articleTitle.setEntityName("文章标题");
        articleTitle.setTitleContent("内容修改_塑中国面孔，铸美丽华夏");
        articleTitle.setCreatTime("2022-04-30 00:00:00");
        articleTitle.setUpdateTime("2022-04-30 00:00:00");

        articleTitle.setRelTitleParagraphs(rels);

        long start = System.currentTimeMillis();
        ArticleTitle save = articleRepository.save(articleTitle);
        long end = System.currentTimeMillis();
        int i=1/0;

        System.out.println("--------创建耗时: " + (end - start) + "秒");
        System.out.println(JSONObject.toJSON(save));


    }


    @Test
    @Version
    public void createParagraph() {

        ArticleParagraph paragraph1 = new ArticleParagraph();
//        paragraph1.setEntityId("66483225-1f89-4919-b8bb-3ea0f87de0da");
        paragraph1.setEntityName("文章段落单独");
        paragraph1.setParagraphContent("时间从2020年的初春一路蹒跚到繁花似锦、绿树蓊郁的仲夏，清风吹过，我听见回 响一来自山谷和心间。在那动人的回响中，青春的呐喊犹如雏凤的啼鸣一清脆而悦 耳；在那美丽的土地上，一张张青春的面孔犹如盛开的夏花一明艳而璀璨。");
        paragraph1.setCreatTime("2022-04-30 00:00:00");
        paragraph1.setUpdateTime("2022-04-30 00:00:00");
        paragraph1.setUpdateUser("admin_单独");
        paragraph1.setTag("高考满分作文_单独");
        paragraph1.setRelKeyParagraphs(createRel(999));

        long start = System.currentTimeMillis();
        ArticleParagraph save = paragraphRepository.save(paragraph1);
        long end = System.currentTimeMillis();
        System.out.println("--------创建耗时: " + (end - start) + "秒");
        System.out.println(JSONObject.toJSON(save));


    }

    @Test
    public void query(){

        // 查询节点
        Optional<ArticleTitle> byId = articleRepository.findById("9945176e-447a-430b-8b7b-e53a3c7372c7");
        System.out.println(JSONObject.toJSON(byId));
//
//        ArticleTitle articleTitle = articleRepository.queryArticle();
//
//        Optional<ArticleTitle> byId = articleRepository.findById("9f0e7c8a-805c-4287-93f6-b45c3a63cbbb");
//        Optional<ArticleTitle> byId = articleRepository.findById("967");
//        System.out.println(byId);
//                personService.create();
    }
}