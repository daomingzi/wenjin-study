package com.example.contrller;

import com.example.dto.RenewManagementCallBackRequest;
import com.example.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestController
@RequestMapping("/common")
@AllArgsConstructor
public class CommonController {

    private final CommonService commonService;


    @GetMapping(value = "/ok")
    public String ok() throws IOException {
        return "ok";
    }

    @GetMapping(value = "/image", produces = {MediaType.IMAGE_GIF_VALUE})
    public byte[] image() throws IOException {

//        File file = new File("/Users/gavin/Documents/Java/Java学习资料/Java中高级核心知识全面解析.pdf");
        File file = new File("/Users/gavin/Pictures/Photos Library.photoslibrary/resources/derivatives/1/10F7608D-E930-4217-8A7D-57E433901ED4_1_105_c.jpeg");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[30000000];

        fileInputStream.read(bytes);
        return bytes;
    }

    @GetMapping(value = "/product/low-rate")
    public String lowRate() throws IOException {
        RenewManagementCallBackRequest request = new RenewManagementCallBackRequest();
        request.setSendCode("applycode-001");
        request.setAgentCode("agentCode-001");
        request.setAgentTel("17555123388");
        request.setResult("N");
        request.setUpdateTime(LocalDateTime.now());
        request.setRemark("delay mq callback");
        commonService.productLoeRateMessage(request);
        return "product a low-rate message";
    }

}
