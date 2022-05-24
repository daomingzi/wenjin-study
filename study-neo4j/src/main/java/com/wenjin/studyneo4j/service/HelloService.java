package com.wenjin.studyneo4j.service;

import com.wenjin.studyneo4j.coponent.HelloComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangwj.
 * @date 2022/5/11
 */
@Service
public class HelloService {

    @Autowired
    private HelloComponent helloComponent;
    public void hello() {
        helloComponent.hello();
    }
}
