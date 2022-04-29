package com.wenjin.studyneo4j.service;

import com.wenjin.studyneo4j.entity.node.PersonEntity;
//import com.wenjin.studyneo4j.repository.ArticleRepository;
import com.wenjin.studyneo4j.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author huangwj.
 * @date 2022/4/26
 */

@Service
@AllArgsConstructor
public class PersonService {


//    private final PersonRepository personRepository;
//    private final ArticleRepository articleRepository;

    public void create() {
        PersonEntity person = new PersonEntity(1995, "tom");
//        personRepository.(person);

    }

}
