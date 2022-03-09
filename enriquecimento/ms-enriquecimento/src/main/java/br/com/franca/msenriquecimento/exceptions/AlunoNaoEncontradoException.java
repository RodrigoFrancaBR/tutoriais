package br.com.franca.msenriquecimento.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException {
    public AlunoNaoEncontradoException(String message) {
        super(message);
    }
}
