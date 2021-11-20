package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.service.notificacao.NotificadorEmail;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AtivacaoClienteServiceTest {

    @DisplayName("Deve ativar o cliente e notificar por SMS quando cliente for válido.")
    @Test
    void ativar_deveAtivarClienteNotificandoPorSMS_quandoValido(){

        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        // NotificadorSMS notificadorSMS = new NotificadorSMS();
        NotificadorEmail notificadorSMS = new NotificadorEmail(false, "");

        AtivacaoClienteService service = new AtivacaoClienteService(notificadorSMS);
        // AtivacaoClienteService service = new AtivacaoClienteService();

        // String tipoDeNotificacao = service.ativar(rodrigo);
        service.ativar(rodrigo);

        Assertions.assertThat(rodrigo.isAtivo()).isTrue();
        // Assertions.assertThat(tipoDeNotificacao).isEqualTo("SMS");
    }

    @DisplayName("Deve ativar o cliente e notificar por Email quando cliente for válido.")
    @Test
    void ativar_deveAtivarClienteNotificandoPorEmail_quandoInativo(){

        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        NotificadorEmail notificadorEmail = new NotificadorEmail(false, "");

        AtivacaoClienteService service = new AtivacaoClienteService(notificadorEmail);
        // AtivacaoClienteService service = new AtivacaoClienteService();

        // String tipoDeNotificacao = service.ativar(rodrigo);
        service.ativar(rodrigo);

        Assertions.assertThat(rodrigo.isAtivo()).isTrue();
        // Assertions.assertThat(tipoDeNotificacao).isEqualTo("EMAIL");
    }



}
