package br.com.franca.algoritimos1;

import br.com.franca.algoritimos1.domain.model.Carro;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TesteDeOrdenacao {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(Algoritimos1Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // CozinhaRepository repository = applicationContext.getBean(CozinhaRepository.class);

        Carro lamborghini = new Carro("Lamborghini", new BigDecimal("1000.000")); // 0
        Carro jipe = new Carro("Jipe", new BigDecimal("46.000")); // 1
        Carro brasilia = new Carro("Brasilia", new BigDecimal("16.000")); // 2
        Carro smart = new Carro("Smart", new BigDecimal("46.000")); // 3
        Carro fusca = new Carro("Fusca", new BigDecimal("17.000")); // 4

        Carro[] carros = new Carro[5];



        for(int i = 0 ; i< carros.length; i++) {

            for (int j= 0; j< carros.length; j++) {

                Carro carroMaisBarato = carros[j];

                if (carros[j].getValor().compareTo(carroMaisBarato.getValor())==-1){
                    carroMaisBarato = carros[j];
                }
            }
        }


    }

}
