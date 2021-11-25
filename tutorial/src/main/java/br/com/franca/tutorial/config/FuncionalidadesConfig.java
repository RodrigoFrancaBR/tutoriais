package br.com.franca.tutorial.config;

import br.com.franca.tutorial.service.funcionalidades.FuncionalidadeEscrever;
import br.com.franca.tutorial.service.funcionalidades.FuncionalidadeLer;
import br.com.franca.tutorial.service.funcionalidades.Funcionalidades;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuncionalidadesConfig {

    @Bean(name = "escrever1")
    // @ConditionalOnProperty(prefix = "tipo", name = "funcionalidade", havingValue = "escrever")
    @ConditionalOnProperty(prefix = "spring", name = "profiles.active", havingValue = "prod")
    public Funcionalidades funcionalidadeEscrever(){
        return new FuncionalidadeEscrever();
    }

    @Bean(name = "ler1")
    // @ConditionalOnProperty(prefix = "tipo", name = "funcionalidade", havingValue = "ler")
    @ConditionalOnProperty(prefix = "spring", name = "profiles.active", havingValue= "local")
    public Funcionalidades funcionalidadeLer(){
        return new FuncionalidadeLer();
    }
}
