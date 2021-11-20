package br.com.franca.tutorial.domain.model.enums;

/**
 * Poderia ter usado lombok aqui... mas não quis.
 */
public enum Prioridade {

    UM(1, "um"){},

    DOIS(2, "dois"){};

    private int chave;
    private String valor;

    private Prioridade(int chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }
}
