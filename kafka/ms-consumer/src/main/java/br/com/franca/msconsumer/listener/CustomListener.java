package br.com.franca.msconsumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CustomListener {

    // vou ouvir o topic-1
    @KafkaListener(topics = "topic-1", groupId = "group-1")
    public void listen(List<String> messages) {
        log.info("Thread: {} ", Thread.currentThread().getId(), messages);
        log.info("received: {} ", messages);
    }

    // vou ouvir o topic-2
    @KafkaListener(topics = "topic-2", groupId = "group-2")
    public void listen2(List<String> messages) {
        log.info("Thread: {} ", Thread.currentThread().getId(), messages);
        log.info("received: {} ", messages);
    }

    // vou ouvir o topic-3
    @KafkaListener(topics = "topic-3", groupId = "group-3")
    public void listen3(List<String> messages) {
        log.info("Thread: {} ", Thread.currentThread().getId(), messages);
        log.info("received: {} ", messages);
    }

    // vou ouvir o topic-4
    @KafkaListener(topics = "topic-4", groupId = "group-4")
    public void listen4(List<String> messages) {
        log.info("Thread: {} ", Thread.currentThread().getId(), messages);
        log.info("received: {} ", messages);
    }
}
