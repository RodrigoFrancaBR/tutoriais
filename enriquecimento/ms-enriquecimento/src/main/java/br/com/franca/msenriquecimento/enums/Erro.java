package br.com.franca.msenriquecimento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Erro {
    ALUNO_NAO_ENCONTRADO("E001", "Erro!! aluno não encontrado");

    private String chave;
    private String valor;

    }
