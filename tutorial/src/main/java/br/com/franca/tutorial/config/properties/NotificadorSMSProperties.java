package br.com.franca.tutorial.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("notificador.sms")
@Component
@Getter
@Setter
public class NotificadorSMSProperties {
    // prioridade para o valor que está no app.properties
    private String operadoraCelular= "OI";
}
