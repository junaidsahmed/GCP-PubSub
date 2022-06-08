package com.demo.project.gcbpubsub.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Data
public class OrderDto {

    private Integer orderId;
    private LocalDateTime orderDate;
    private Integer orderMode;
    private Integer customerId;
    private Integer orderStatus;
    private Integer orderTotal;
    private Integer saleRepId;
    private Integer promotionId;
}
