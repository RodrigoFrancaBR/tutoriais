package br.com.franca.msproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

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
        HashMap configs = new HashMap<String, Object>();

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

    /**
     * O Kafka cria tópicos caso o tópico não exista e
     * é possivel criar os tópicos pela aplicação conforme abaixo
     *
     * @return
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        HashMap configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    /**
     1 Tópico será criado conforme as configurações abaixo:
     Nome do tópico, Partiçoes e Replicas

     @Bean public NewTopic topic() {
     return new NewTopic("topic-1", 10, Short.valueOf("1"));
     }
     */

    /**
     * 2 - Tópico será criado apartir do que está configurado no broker
     */
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic-2").build();
    }

    /**
     * 3 - Criação de vários tópico
     */
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("topic-3").build(),
                TopicBuilder.name("topic-4").build()
        );
    }
}
