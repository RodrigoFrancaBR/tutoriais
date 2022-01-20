package br.com.franca.msproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

/**
 *
 */
@RequiredArgsConstructor
@Configuration
public class KafkaConfig {
    // pegar conf do arquivo .yml
    private final KafkaProperties properties;

    /**
     * Configurações para serialização dos envio de msg
     */
    @Bean
    public ProducerFactory<String, String> factory() {
        var configs = new HashMap<String, Object>();

        // endereço do broker
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());

        // como é a serialização das keys (chave de envio é serializada)
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // como é a serialização dos value (valor de envio é serializado)
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, String> template() {
        return new KafkaTemplate<>(factory());
    }

    // o kafka cria topicos caso o tópico não exista
    // É possível riar os tópicos pela aplicação

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("topic-1", 10, Short.valueOf("1"));
    }
}
