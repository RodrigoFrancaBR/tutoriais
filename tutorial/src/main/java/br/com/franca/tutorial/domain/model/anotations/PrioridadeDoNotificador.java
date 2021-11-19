package br.com.franca.tutorial.domain.model.anotations;

import br.com.franca.tutorial.domain.model.enums.Prioridade;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// diz que a anotação só existe em tempo de execução.
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface PrioridadeDoNotificador {
    Prioridade value();
}
