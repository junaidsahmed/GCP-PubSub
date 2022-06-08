package com.demo.project.gcbpubsub.pubsub.subscriber;


import com.demo.project.gcbpubsub.dto.OrderDto;
import com.demo.project.gcbpubsub.pubsub.consumer.OrderConsumer;
import com.demo.project.gcbpubsub.pubsub.consumer.PubSubConsumer;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
public class OrderSubscriber {

    private PubSubConsumer<OrderDto> orderOrderConsumer;
    private PubSubTemplate pubSubTemplate;

    @Autowired
    public OrderSubscriber(OrderConsumer orderOrderConsumer, PubSubTemplate pubSubTemplate) {
        this.orderOrderConsumer = orderOrderConsumer;
        this.pubSubTemplate = pubSubTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void subscribe(){
        log.info("Subscribing to {} ", orderOrderConsumer.getSubscriptionName());
        pubSubTemplate.subscribeAndConvert(orderOrderConsumer.getSubscriptionName(),
                orderOrderConsumer.messageConsumer(),
                orderOrderConsumer.payloadType());
    }
}
