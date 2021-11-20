package br.com.franca.tutorial.config;

import br.com.franca.tutorial.config.properties.NotificadorEmailProperties;
import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.service.notificacao.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class NotificadorEmailConfig {

      @Autowired
      private NotificadorEmailProperties notificadorEmailProperties;

    /**
     * Não quero mais que o Spring gerencie o Notificador de Email
     * através do @Componente. Eu quero ensinar para o Spring
     * como se configura e instancia esse beam sem a anotação @component
     *
     */

//    @Profile("dev")
    @PrioridadeDoNotificador(Prioridade.DOIS)
    @Bean
    public NotificadorEmail notificadorEmail (){
        System.out.println("Instanciando um Notificador de EMAIL " +
                "através da classe NotificadorEmailConfig anotada com @Configuration");

        System.out.println("SERVER PORT: " + notificadorEmailProperties.getPortaServidor());

        boolean caixaAlta = true;
        String hostServerSMTP = "smtp.meuemail.com.br";
        return new NotificadorEmail(caixaAlta, hostServerSMTP);
    }
}
