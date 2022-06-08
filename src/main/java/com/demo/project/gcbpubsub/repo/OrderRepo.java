package com.demo.project.gcbpubsub.repo;

import com.demo.project.gcbpubsub.entity.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepo extends MongoRepository<Order, ObjectId> {

    Optional<Order> findByOrderId(Integer orderId);
}
