package com.demo.project.gcbpubsub.controller;

import com.demo.project.gcbpubsub.dto.OrderDto;
import com.demo.project.gcbpubsub.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("v1")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/date",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getDate(){
        return orderService.getOrders();
    }


}
