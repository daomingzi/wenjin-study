package com.example.common.constant;

/**
 * @author huangwj.
 * @date 2021/7/11
 */
public interface RabbitMQConstant {
    /**
     * 延时队列交换机
     */
    String DELAY_EXCHANGE_NAME = "delay_exchange";
    /**
     * 延时队列-低继续率管理-2day
     */
    String DELAY_QUEUE_LOW_RATE_2D = "delay_queue_lowRate_2day";
    /**
     * 延时队列-低继续率管理-2day-路由
     */
    String DELAY_QUEUE_LOW_RATE_2D_ROUTING_KEY = "delay_queue_lowRate_2day_routingKey";
    /**
     * 死信队列交换机
     */
    String DEAD_LETTER_EXCHANGE = "deadLetter_exchange";
    /**
     * 死信队列-低继续率
     */
    String DEAD_LETTER_QUEUE_LOW_RATE = "deadLetter_queue_lowRate";
    /**
     * 死信队列-低继续率-路由
     */
    String DEAD_LETTER_QUEUE_LOW_RATE_ROUTING_KEY = "deadLetter_queue_lowRate_routingKey";

}
