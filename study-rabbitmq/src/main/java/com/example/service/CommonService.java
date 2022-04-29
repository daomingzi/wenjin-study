package com.example.service;

import com.example.common.constant.RabbitMQConstant;
import com.example.dto.RenewManagementCallBackRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author huangwj.
 * @date 2021/7/12
 */

@Service
@AllArgsConstructor
@Slf4j
public class CommonService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    /**
     * 发送延时消息, 2day
     *
     * @author huangwj.
     * @date 2021/7/11 6:45 下午
     */
    public void productLoeRateMessage(RenewManagementCallBackRequest request) {

        try {
            log.info("send a message, time: {}, msg: {}, , queue: {}",  LocalDateTime.now(),
                    objectMapper.writeValueAsString(request), RabbitMQConstant.DELAY_EXCHANGE_NAME);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        rabbitTemplate.convertAndSend(RabbitMQConstant.DELAY_EXCHANGE_NAME,
                RabbitMQConstant.DELAY_QUEUE_LOW_RATE_2D_ROUTING_KEY, request);

    }
}
