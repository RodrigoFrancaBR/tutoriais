package br.com.franca.msproducer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping("api/producer")
@RestController
public class ProducerController {

    private final KafkaTemplate<String, String> template;

    @GetMapping("/send")
    public ResponseEntity<Void> send() {
        template.send("topic-1", "Envio de: " + LocalDateTime.now());
        return ResponseEntity.ok().build();
    }
}
