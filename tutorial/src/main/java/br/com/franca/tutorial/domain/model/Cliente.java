package br.com.franca.tutorial.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private boolean ativo = false;
}
