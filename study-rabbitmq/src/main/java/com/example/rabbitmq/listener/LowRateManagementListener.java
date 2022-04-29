package com.example.rabbitmq.listener;

import com.example.common.constant.RabbitMQConstant;
import com.example.config.AmqpConfig;
import com.example.dto.RenewManagementCallBackRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @author huangwj.
 * @date 2021/7/11
 */
@Component
@Slf4j
@AllArgsConstructor
public class LowRateManagementListener {

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitMQConstant.DEAD_LETTER_QUEUE_LOW_RATE)
    public void receiveA(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        String msg = new String(message.getBody());
        log.info("当前时间：{},死信队列A收到消息：{}", LocalDateTime.now(), msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        try {
            byte[] body = message.getBody();
            if (body == null || body.length == 0) {
                log.error("Received low-rate message with empty body. Discard this message");
                return;
            }

            // Process the message body
            String data = new String(body, StandardCharsets.UTF_8);
            log.info("Received a message, time: {}, low-rate management result: {}, tag: {}", LocalDateTime.now(),
                    objectMapper.writeValueAsString(data), tag);
            RenewManagementCallBackRequest request = objectMapper.readValue(data, RenewManagementCallBackRequest.class);

            log.info("data: {}", request);


        } catch (Throwable t) {
            log.error("Failed to process low-rate management message: ", t);
        } finally {
            AmqpConfig.ack(channel, tag);
        }
    }
}
