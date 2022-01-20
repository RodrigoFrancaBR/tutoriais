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
}
