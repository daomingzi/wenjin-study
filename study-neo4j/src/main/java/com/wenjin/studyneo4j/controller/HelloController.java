package com.wenjin.studyneo4j.controller;

import com.wenjin.studyneo4j.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author huangwj.
 * @date 2022/5/11
 */

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    public void hello() {

        helloService.hello();
    }
}
