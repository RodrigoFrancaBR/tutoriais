package br.com.franca.apienriquecimento.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PessoaDTO {

    private String nome;
    private String cpf;
    private String rg;
    private String orgaoExp;
    private String ufRg;
    private String sexo;
    private LocalDate nascimento;
    private String email;
    private String celular;
    private String residencial;
    private String pai;
    private String mae;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
}
