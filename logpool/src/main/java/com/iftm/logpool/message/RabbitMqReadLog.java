package com.iftm.logpool.message;

import com.iftm.logpool.entities.dtos.LogDto;
import com.iftm.logpool.services.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReadLog {

    @Autowired
    private LogService service;

    @RabbitListener(queues = "${newsletter.rabbitmq.queue}")
    public void receiveLogActionCreate(@Payload LogDto logDto){
        if(logDto != null) service.save(logDto);
    }
    
}
