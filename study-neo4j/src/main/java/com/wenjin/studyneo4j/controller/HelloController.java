package com.wenjin.studyneo4j.controller;

import com.wenjin.studyneo4j.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangwj.
 * @date 2022/5/11
 */

@RestController
@RequestMapping("/holle")
@Api(tags = "连通性测试")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/ok")
    @ApiOperation(value = "测试")
    public String hello() {

        helloService.hello();
        return "ok";
    }
}
