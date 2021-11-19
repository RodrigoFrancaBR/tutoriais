package br.com.franca.tutorial.config;

import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.notificacao.NotificadorEmail;
import br.com.franca.tutorial.service.AtivacaoClienteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NotificadorEmailConfig {

    /**
     * Não quero mais que o Spring gerencia o Notificador de Email
     * através do @Componente. Eu quero ensinar para o Spring
     * como se configura e instancia esse beam sem a anotação @component
     *
     */

    @PrioridadeDoNotificador(Prioridade.DOIS)
    // @Qualifier("prioridade-1")
    // @Primary
    @Bean
    public NotificadorEmail notificadorEmail (){
        System.out.println("Instanciando um Notificador de EMAIL " +
                "através da classe NotificadorEmailConfig anotada com @Configuration");
        boolean caixaAlta = true;
        String hostServerSMTP = "smtp.meuemail.com.br";
        return new NotificadorEmail(caixaAlta, hostServerSMTP);
    }

//    @Bean
//    public AtivacaoClienteService ativacaoClienteService() {
//        return new AtivacaoClienteService(notificadorEmail());
//    }
}
