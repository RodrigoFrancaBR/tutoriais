package br.com.franca.tutorial.config;

import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.service.notificacao.Notificador;
import br.com.franca.tutorial.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtivacaoClienteServiceConfig {

    @Bean(initMethod = "methodName1", destroyMethod = "methodName2")
    public AtivacaoClienteService ativacaoClienteService(
            @PrioridadeDoNotificador(Prioridade.UM)
            Notificador notificador) {
        System.out.println("Instanciando uma Ativacao de Cliente Service " +
                "através da classe AtivacaoClienteServiceConfig anotada com @Configuration");
        return new AtivacaoClienteService(notificador);
    }
}
