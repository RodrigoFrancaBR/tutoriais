package br.com.franca.apienriquecimento.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Erro {
    PESSOA_NAO_ENCONTRADA("E001", "Erro!! pessoa não encontrada"),
    TOKEN_INVALIDO("E002", "Erro!! token inválido"),
    CONVERSAO_FALHOU("E003", "Não foi possível converter");

    private String chave;
    private String valor;

}
