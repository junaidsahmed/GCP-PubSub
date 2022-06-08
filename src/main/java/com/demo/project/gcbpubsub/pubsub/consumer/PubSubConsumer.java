package com.demo.project.gcbpubsub.pubsub.consumer;

import com.google.cloud.spring.pubsub.support.converter.ConvertedBasicAcknowledgeablePubsubMessage;

import java.util.function.Consumer;

public interface PubSubConsumer<T> {

    String getSubscriptionName();

    Class<T> payloadType();

    Consumer<ConvertedBasicAcknowledgeablePubsubMessage<T>> messageConsumer();

}