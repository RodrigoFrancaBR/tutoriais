package br.com.franca.algoritimos1;

import br.com.franca.algoritimos1.domain.model.Funcionario;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Trabalhar numa empresa é algo interessante, ainda mais se você ganha um bom salário, certo?
 * Vejamos uma lista de afortunados, inclusive já adotamos a posição 0 para o primeiro elemento
 * e 3 para o último.
 *
 * 0 - Fernando R$ 3.200,00
 * 1 - Alfredo R$ 6.000,00
 * 2- Flávio R$ 5.000,00
 * 3 - Marcela R$ 2.200,00
 * Dessa vez implemente um algoritmo que descubra o menor salário e também o maior.
 */
public class TesteDoMenorE_MaiorSalario {

    public static void main(String[] args) {
        // outra forma de se instanciar
        // Produto[] produtos = { new Produto("Fusca", 13.000), new Produto("Jipe", 45.000) };

        Funcionario fernanda = new Funcionario("Fernando", new BigDecimal("3200"));
        Funcionario alfredo = new Funcionario("Alfredo", new BigDecimal("6000"));
        Funcionario flavio = new Funcionario("Flávio", new BigDecimal("5000"));
        Funcionario marcela = new Funcionario("Marcela", new BigDecimal("2200"));

        List<Funcionario> funcionarios = Arrays.asList(fernanda, alfredo, flavio, marcela);
        Funcionario funcionarioComMenorSalario = funcionarios.get(0);
        Funcionario funcionarioComMaiorsalrio = funcionarios.get(0);


        for (Funcionario funcionarioAtual:funcionarios) {

            if (funcionarioAtual.getSalario().compareTo(funcionarioComMenorSalario.getSalario())==-1){
                funcionarioComMenorSalario = funcionarioAtual;
            }

            if (funcionarioAtual.getSalario().compareTo(funcionarioComMaiorsalrio.getSalario())==1){
                funcionarioComMaiorsalrio = funcionarioAtual;
            }
        }

        System.out.println(" Funcionário com o menor salário é: " + funcionarioComMenorSalario.getNome());
        System.out.println(" salário: " + funcionarioComMenorSalario.getSalario());

        System.out.println(" Funcionário com o maior salário é: " + funcionarioComMaiorsalrio.getNome());
        System.out.println(" salário: " + funcionarioComMaiorsalrio.getSalario());


    }

}
