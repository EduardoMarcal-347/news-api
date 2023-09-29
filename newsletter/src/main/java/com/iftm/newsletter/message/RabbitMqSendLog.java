package com.iftm.newsletter.message;

import com.iftm.newsletter.entities.dtos.LogDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqSendLog {

    @Value("${news.exchange}")
    private String exchange;

    @Value("${news.employee.routingkey}")
    private String routingKey;

    @Value("${news.queue}")
    private String queue;

    public final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSendLog(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void sendLog(LogDto logDto) {
        rabbitTemplate.execute(channel -> {
            channel.exchangeDeclare(exchange, "direct", true);
            channel.queueDeclare(queue, true, false, false, null);
            channel.queueBind(queue, exchange, routingKey);
            return null;
        });
        rabbitTemplate.convertAndSend(exchange, routingKey, logDto);
    }
}
