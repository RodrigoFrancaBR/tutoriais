package br.com.franca.tutorial.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("notificador.email")
@Component
@Getter
@Setter
public class NotificadorEmailProperties {
    // prioridade para o valor que está no app.properties
     private Integer portaServidor=29;
}
