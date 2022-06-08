package com.demo.project.gcbpubsub.mappers;

import com.demo.project.gcbpubsub.dto.OrderDto;
import com.demo.project.gcbpubsub.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);
    Order orderDtoToOrder(OrderDto orderDto);


}
