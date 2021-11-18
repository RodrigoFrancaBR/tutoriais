package br.com.franca.tutorial.config;

import br.com.franca.tutorial.notificacao.Notificador;
import br.com.franca.tutorial.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtivacaoClienteServiceConfig {

    @Bean
    public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
        System.out.println("Instanciando uma Ativacao de Cliente Service " +
                "através da classe AtivacaoClienteServiceConfig anotada com @Configuration");
        return new AtivacaoClienteService(notificador);
    }
}
