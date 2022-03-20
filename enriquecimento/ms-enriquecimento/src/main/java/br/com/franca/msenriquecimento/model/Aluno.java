package br.com.franca.msenriquecimento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "tb_aluno")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String orgaoExp;
    private String ufRg;
    // ADD Sexo como enum
    private String sexo;
    private LocalDate nascimento;
    // ADD Email como classe ou lista
    private String email;
    private String celular;
    // ADD como Lista
    private String residencial;
    private String pai;
    private String mae;
    private String cep;
    // ADD Endereço como classe
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    // objeto que pode ter residencial e celular lista de tel
    // private Telefone telefone
}
