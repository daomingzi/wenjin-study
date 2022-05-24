package com.wenjin.studyneo4j.controller;

import com.wenjin.studyneo4j.service.HelloService;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class HelloControllerTest {
    @Autowired
    private HelloService helloService;

//    @Test
    void hello() {
        helloService.hello();

        HelloController helloController = new HelloController();
        helloController.hello();
    }

}