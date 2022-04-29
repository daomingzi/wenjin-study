package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

@SpringBootConfiguration
@Order // 使用默认值（最小）确保在消费消息时依赖的服务都初始化完成
@Slf4j
public class AmqpConfig {

    @Bean
    public MessageConverter rabbitMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean(name = "amqGavinConnectionFactory")
    @Primary
    public ConnectionFactory amqBaobaoYunbaoConnectionFactory(@Value("${spring.rabbitmq.host}") String host,
                                                              @Value("${spring.rabbitmq.port}") int port,
                                                              @Value("${spring.rabbitmq.username}") String username,
                                                              @Value("${spring.rabbitmq.password}") String password,
                                                              @Value("${spring.rabbitmq.virtual-host}") String virtualHost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate amqpTemplate(@Qualifier("amqGavinConnectionFactory") ConnectionFactory connectionFactory,
                                       MessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setChannelTransacted(true);
        template.setMessageConverter(messageConverter);
        return template;
    }


    @Bean(name = "amqGavinContainerFactory")
    @Primary
    public SimpleRabbitListenerContainerFactory amqGavinFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("amqGavinConnectionFactory") ConnectionFactory connectionFactory,
            @Value("${spring.rabbitmq.listener.simple.acknowledge-mode}") String acknowledgeMode,
            @Value("${spring.rabbitmq.listener.simple.max-concurrency}") Integer maxConcurrency,
            @Value("${spring.rabbitmq.listener.simple.concurrency}") Integer concurrency) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setMaxConcurrentConsumers(maxConcurrency);
        factory.setConcurrentConsumers(concurrency);
        factory.setPrefetchCount(0);
        configurer.configure(factory, connectionFactory);
        return factory;
    }


    public static void ack(Channel channel, long deliveryTag) {
        try {
            long start = System.currentTimeMillis();
            channel.basicAck(deliveryTag, false);
            long cost = System.currentTimeMillis() - start;
            log.info("ack message cost {} ms", cost);
        } catch (Throwable t) {
            log.warn("Ack message", t);
        }
    }

    public static void nack(Channel channel, long deliveryTag, boolean requeue) {
        try {
            channel.basicNack(deliveryTag, false, requeue);
        } catch (Throwable t) {
            log.warn("Nack message", t);
        }
    }

}
