package br.com.franca.apienriquecimento.exception;

public class PessoaNaoEncontradaException extends RuntimeException {
    public PessoaNaoEncontradaException(String message) {
        super(message);
    }
}
