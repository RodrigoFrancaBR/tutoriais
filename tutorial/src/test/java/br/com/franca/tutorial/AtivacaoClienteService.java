package br.com.franca.tutorial;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.service.ClienteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AtivacaoClienteService {

    @DisplayName("Deve ativar o cliente quando for Inativo")
    @Test
    void deveAtivarClienteQuandoForInativo(){
        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        ClienteService service = new ClienteService();
        service.ativar(rodrigo);
        Assertions.assertThat(rodrigo.isAtivo()).isTrue();
    }
}
