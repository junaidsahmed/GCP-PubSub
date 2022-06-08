package com.demo.project.gcbpubsub.service;

import com.demo.project.gcbpubsub.dto.OrderDto;
import com.demo.project.gcbpubsub.event.OrderEvent;

import java.util.List;

public interface OrderService {

    void listenAndSaveOrderDetails(OrderEvent event);
    List<OrderDto> getOrders();
}
