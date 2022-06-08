package com.demo.project.gcbpubsub.pubsub.consumer;

import com.demo.project.gcbpubsub.dto.OrderDto;
import com.demo.project.gcbpubsub.event.OrderEvent;
import com.google.cloud.spring.pubsub.support.converter.ConvertedBasicAcknowledgeablePubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class OrderConsumer implements PubSubConsumer<OrderDto>{
    private final String subscriptionName;
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderConsumer(@Value("${gcp.pubsub.test.subscription}")  String subscriptionName,ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
        this.subscriptionName = subscriptionName;
    }

    @Override
    public String getSubscriptionName() {
        return this.subscriptionName;
    }

    @Override
    public Class<OrderDto> payloadType() {
        return OrderDto.class;
    }

    @Override
    public Consumer<ConvertedBasicAcknowledgeablePubsubMessage<OrderDto>> messageConsumer() {
        return this::consumeMessage;
    }

    private void consumeMessage(ConvertedBasicAcknowledgeablePubsubMessage<OrderDto> message){
        try {
            OrderDto payload = message.getPayload();
            log.info("subscription name {}  and consumeMessage() pulled message {}", subscriptionName, payload.toString());
            applicationEventPublisher.publishEvent(new OrderEvent(payload));
        }catch(Exception ex){
            log.error(ex.getMessage());
        }
        finally {
            message.ack();
        }
    }
}
