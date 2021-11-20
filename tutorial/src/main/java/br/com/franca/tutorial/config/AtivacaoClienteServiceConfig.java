package br.com.franca.tutorial.config;

import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.notificacao.Notificador;
import br.com.franca.tutorial.service.AtivacaoClienteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtivacaoClienteServiceConfig {

    @Bean
    public AtivacaoClienteService ativacaoClienteService(
            @PrioridadeDoNotificador(Prioridade.UM)
            // @Qualifier("prioridade-1")
            Notificador notificador) {
//    public AtivacaoClienteService ativacaoClienteService() {
        System.out.println("Instanciando uma Ativacao de Cliente Service " +
                "através da classe AtivacaoClienteServiceConfig anotada com @Configuration");
        return new AtivacaoClienteService(notificador);
        // return new AtivacaoClienteService();
    }
}
