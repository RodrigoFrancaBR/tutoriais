package br.com.franca.apienriquecimento.exception;

public class ConvertException extends RuntimeException {
    public ConvertException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
