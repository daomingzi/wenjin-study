package com.example.contrller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping(value = "/fanglingxiao", produces = {MediaType.IMAGE_GIF_VALUE})
    public byte[] ok() throws IOException {

//        File file = new File("/Users/gavin/Documents/Java/Java学习资料/Java中高级核心知识全面解析.pdf");
        File file = new File("/Users/gavin/Pictures/Photos Library.photoslibrary/resources/derivatives/1/10F7608D-E930-4217-8A7D-57E433901ED4_1_105_c.jpeg");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[30000000];

        fileInputStream.read(bytes);
        return bytes;
    }
}
