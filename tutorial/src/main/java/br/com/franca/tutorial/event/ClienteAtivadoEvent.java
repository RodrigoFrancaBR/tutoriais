package br.com.franca.tutorial.event;

import br.com.franca.tutorial.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Classe responsável por encapsular um evento de ativação de cliente
 * guarda informações sobre o evento de ativação de cliente.
 */
@Getter
@AllArgsConstructor
public class ClienteAtivadoEvent {
    private Cliente cliente;
}
