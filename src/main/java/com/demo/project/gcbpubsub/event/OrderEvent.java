package com.demo.project.gcbpubsub.event;

import com.demo.project.gcbpubsub.dto.OrderDto;


public class OrderEvent {

    public OrderDto orderDto;

    public OrderEvent(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public OrderDto getOrderDto(){
        return this.orderDto;
    }
}
