package org.lyflexi.boot_rabbit_producer;

import org.junit.jupiter.api.Test;
import org.lyflexi.boot_rabbit_producer.config.RabbitMqConstant;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class BootRabbitProducerApplicationTest {



    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test01SendMessage() {
        rabbitTemplate.convertAndSend(RabbitMqConstant.BOOT_TOPIC_EXCHANGE,
                "boot.l.y",
                "Message Test Confirm~~~ ~~~");
    }

}
