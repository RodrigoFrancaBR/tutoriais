package br.com.franca.algoritimos1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carro {

    private String nome;
    private BigDecimal valor;
}
