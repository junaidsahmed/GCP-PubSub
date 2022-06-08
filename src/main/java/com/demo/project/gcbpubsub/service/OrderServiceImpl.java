package com.demo.project.gcbpubsub.service;

import com.demo.project.gcbpubsub.dto.OrderDto;
import com.demo.project.gcbpubsub.entity.Order;
import com.demo.project.gcbpubsub.event.OrderEvent;
import com.demo.project.gcbpubsub.mappers.OrderMapper;
import com.demo.project.gcbpubsub.repo.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    private final OrderMapper orderMapper;
    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderMapper orderMapper, OrderRepo orderRepo) {
        this.orderMapper = orderMapper;
        this.orderRepo = orderRepo;
    }
    @Override
    @EventListener
    public void listenAndSaveOrderDetails(OrderEvent event){
        Order order = orderMapper.orderDtoToOrder(event.orderDto);
        log.info(event.getOrderDto().toString());
        orderRepo.save(order);
    }

    @Override
    public List<OrderDto> getOrders() {
        return orderRepo.findAll().stream().map(orderMapper::orderToOrderDto).toList();
    }


}
