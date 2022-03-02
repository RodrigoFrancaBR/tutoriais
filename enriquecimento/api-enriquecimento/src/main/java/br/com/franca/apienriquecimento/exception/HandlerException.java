package br.com.franca.apienriquecimento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ResponseBody
    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<String> pessoaNaoEncontradaException(Throwable ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(TokenInvalidoException.class)
    public ResponseEntity<String> tokenInvalidoException(Throwable ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }
}
