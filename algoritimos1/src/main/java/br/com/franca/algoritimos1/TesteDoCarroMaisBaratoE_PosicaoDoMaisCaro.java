package br.com.franca.algoritimos1;

import br.com.franca.algoritimos1.domain.model.Carro;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TesteDoCarroMaisBaratoE_PosicaoDoMaisCaro {

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

        List<Carro> carros = Arrays.asList(lamborghini, jipe, brasilia, smart, fusca);

        // Carro carroMaisBarato = new Carro("PrimeiroCarro", BigDecimal.valueOf(Double.MAX_VALUE));
        Carro carroMaisBarato = carros.get(0);
        int posicaoDoCarroMaisCaro =0;

        // vá do 0 até o 4 inclusive
        //ou vá do 0 até 5 exclusive
        for (Carro carroAtual : carros) {

            if (carroAtual.getValor().compareTo(carroMaisBarato.getValor()) == -1) {
                carroMaisBarato = carroAtual;
            }

            Carro carroMaisCaro = carros.get(posicaoDoCarroMaisCaro);

            if (carroAtual.getValor().compareTo(carroMaisCaro.getValor())==1){
                posicaoDoCarroMaisCaro = carros.indexOf(carroAtual);
            }
        }

        System.out.println(" Carro mais barato é: " + carroMaisBarato.getNome());
        System.out.println(" Valor: " + carroMaisBarato.getValor());

        System.out.println(" Carro mais caro é: " + carros.get(posicaoDoCarroMaisCaro).getNome());
        System.out.println(" Valor: " + carros.get(posicaoDoCarroMaisCaro).getValor());
    }
}
