package com.demo.project.gcbpubsub.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "order")
@Data
@Builder
public class Order {
    @BsonId
    private ObjectId _id;
    private Integer orderId;
    private LocalDateTime orderDate;
    private Integer orderMode;
    private Integer customerId;
    private Integer orderStatus;
    private Integer orderTotal;
    private Integer saleRepId;
    private Integer promotionId;

    public String get_id() {
        return _id != null ? _id.toHexString() : null;
    }
}
