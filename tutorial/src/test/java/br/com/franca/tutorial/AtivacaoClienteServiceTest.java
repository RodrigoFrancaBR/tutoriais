package br.com.franca.tutorial;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.notificacao.NotificadorEmail;
import br.com.franca.tutorial.service.AtivacaoClienteService;
import br.com.franca.tutorial.service.EmissaoNotaFiscalService;
import br.com.franca.tutorial.notificacao.NotificadorSMS;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class AtivacaoClienteServiceTest {

    @DisplayName("Deve ativar o cliente e enviar SMS quando cliente for válido.")
    @Test
    void ativar_deveAtivarClientePorSMS_quandoValido(){

        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        NotificadorSMS notificadorSMS = new NotificadorSMS();

        AtivacaoClienteService service = new AtivacaoClienteService(notificadorSMS);

        String tipoDeNotificacao = service.ativar(rodrigo);

        Assertions.assertThat(rodrigo.isAtivo()).isTrue();
        Assertions.assertThat(tipoDeNotificacao).isEqualTo("SMS");
    }

    @DisplayName("Deve ativar o cliente e enviar Email quando cliente for válido.")
    @Test
    void ativar_deveAtivarClientePorEmail_quandoInativo(){

        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        NotificadorEmail notificadorEmail = new NotificadorEmail();

        AtivacaoClienteService service = new AtivacaoClienteService(notificadorEmail);

        String tipoDeNotificacao = service.ativar(rodrigo);

        Assertions.assertThat(rodrigo.isAtivo()).isTrue();
        Assertions.assertThat(tipoDeNotificacao).isEqualTo("EMAIL");
    }

    @DisplayName("Deve emitir nota fiscal quando cliente e produto forem validos.")
    @Test
    void emitir_deveEmitirNotaFiscal_quandoClienteProdutoValido(){

        Cliente cliente = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        Produto produto = Produto.builder().nome("computador").valor(new BigDecimal("5000.00")).build();


        EmissaoNotaFiscalService service = new EmissaoNotaFiscalService();

        boolean emitido = service.emitir(cliente, produto);

        Assertions.assertThat(emitido).isTrue();
    }

}
