package br.com.franca.msproducer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/producer")
@RestController
public class ProducerController {

    private final KafkaTemplate<String, String> template;

    @GetMapping("/topic1")
    public ResponseEntity<Void> sendTopic1() {
        log.info("requesting topic-1 !!");
        template.send("topic-1", "Envio de: " + LocalDateTime.now());
        log.info("request topic-1 success !!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/topic2")
    public ResponseEntity<Void> sendTopic2() {
        log.info("requesting topic-2 !!");
        template.send("topic-2", "Envio de: " + LocalDateTime.now());
        log.info("request topic-2 success !!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/topic3")
    public ResponseEntity<Void> sendTopic3() {
        log.info("requesting topic-3 !!");
        template.send("topic-3", "Envio de: " + LocalDateTime.now());
        log.info("request topic-3 success !!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/topic4")
    public ResponseEntity<Void> sendTopic4() {
        log.info("requesting topic-4 !!");
        template.send("topic-4", "Envio de: " + LocalDateTime.now());
        log.info("request topic-4 success !!");
        return ResponseEntity.ok().build();
    }
}
