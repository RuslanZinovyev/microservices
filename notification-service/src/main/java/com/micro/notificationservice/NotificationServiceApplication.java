package com.micro.notificationservice;

import com.micro.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@SpringBootApplication
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notification_topic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
        // send out an email notification
        log.info("Event has received for the following order number: {}", orderPlacedEvent.getOrderNumber());
    }

}
