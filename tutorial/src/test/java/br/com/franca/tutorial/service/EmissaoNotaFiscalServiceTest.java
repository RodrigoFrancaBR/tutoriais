package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.notificacao.Notificador;
import br.com.franca.tutorial.notificacao.NotificadorEmail;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class EmissaoNotaFiscalServiceTest {

    @DisplayName("Deve emitir nota fiscal e notificar por e-mail quando cliente e produto forem validos.")
    @Test
    void emitir_deveEmitirNotaFiscalNotificandoPorEmail_quandoClienteProdutoValido(){

        Cliente cliente = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        Produto produto = Produto.builder().nome("computador").valor(new BigDecimal("5000.00")).build();

        Notificador notificador = new NotificadorEmail(false, "");

        EmissaoNotaFiscalService service = new EmissaoNotaFiscalService(notificador);

        boolean emitido = service.emitir(cliente, produto);

        Assertions.assertThat(emitido).isTrue();
    }

    @DisplayName("Deve emitir nota fiscal e notificar por SMS  quando cliente e produto forem validos.")
    @Test
    void emitir_deveEmitirNotaFiscalNotificarPorSMS_quandoClienteProdutoValido(){

        Cliente cliente = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        Produto produto = Produto.builder().nome("computador").valor(new BigDecimal("5000.00")).build();

        Notificador notificador = new NotificadorEmail(false, "");

        EmissaoNotaFiscalService service = new EmissaoNotaFiscalService(notificador);

        boolean emitido = service.emitir(cliente, produto);

        Assertions.assertThat(emitido).isTrue();
    }
}
