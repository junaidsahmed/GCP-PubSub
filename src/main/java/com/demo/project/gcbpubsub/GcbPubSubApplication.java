package com.demo.project.gcbpubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GcbPubSubApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcbPubSubApplication.class, args);

        System.out.println("hello World");
    }

}
