package com.example.config;

import com.example.common.constant.RabbitMQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangwj.
 * @date 2021/7/11
 */
@Configuration
public class RabbitMQConfig {


    /**
     * 声明延时Exchange
     */
    @Bean("delayExchange")
    public DirectExchange delayExchange() {
        return new DirectExchange(RabbitMQConstant.DELAY_EXCHANGE_NAME);
    }

    /**
     * 声明死信Exchange
     */
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(RabbitMQConstant.DEAD_LETTER_EXCHANGE);
    }

    /**
     * 声明低继续率管理延时队列 延时2day
     * 并绑定到对应的死信交换机
     */
    @Bean("delayQueueLowRate2d")
    public Queue delayQueueA() {
        Map<String, Object> args = new HashMap<>(2);
        // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitMQConstant.DEAD_LETTER_EXCHANGE);
        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", RabbitMQConstant.DEAD_LETTER_QUEUE_LOW_RATE_ROUTING_KEY);
        // x-message-ttl  声明队列的TTL, 2day: 1000 * 60 * 60 * 24 * 2
        args.put("x-message-ttl", 1000 * 20);
        return QueueBuilder.durable(RabbitMQConstant.DELAY_QUEUE_LOW_RATE_2D).withArguments(args).build();
    }

    /**
     * 声明低继续率管理死信队列, 用于处理超过两天未收到续管结果的订单
     */
    @Bean("deadLetterQueueLowRate")
    public Queue deadLetterQueueA() {
        return new Queue(RabbitMQConstant.DEAD_LETTER_QUEUE_LOW_RATE);
    }

    /**
     * 声明低继续率延时队列绑定关系
     */
    @Bean
    public Binding delayBindingA(@Qualifier("delayQueueLowRate2d") Queue queue,
                                 @Qualifier("delayExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.DELAY_QUEUE_LOW_RATE_2D_ROUTING_KEY);
    }

    /**
     * 声明低继续率死信队列绑定关系
     */
    @Bean
    public Binding deadLetterBindingA(@Qualifier("deadLetterQueueLowRate") Queue queue,
                                      @Qualifier("deadLetterExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.DEAD_LETTER_QUEUE_LOW_RATE_ROUTING_KEY);
    }

}
