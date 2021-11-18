package br.com.franca.tutorial.config;

import br.com.franca.tutorial.notificacao.NotificadorEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificadorEmailConfig {

    /**
     * Não quero mais que o Spring gerencia o Notificador de Email
     * através do @Componente. Eu quero ensinar para o Spring
     * como se configura e instancia esse beam sem a anotação @component
     *
     */

    @Bean
    public NotificadorEmail notificadorEmail2 (){
        System.out.println("Instanciando um Notificador de EMAIL " +
                "através da classe anotada com @Configuration");
        boolean caixaAlta = true;
        String hostServerSMTP = "smtp.meuemail.com.br";
        return new NotificadorEmail(caixaAlta, hostServerSMTP);
    }
}
