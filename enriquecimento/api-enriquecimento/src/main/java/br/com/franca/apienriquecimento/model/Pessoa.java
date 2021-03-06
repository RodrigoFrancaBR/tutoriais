package br.com.franca.apienriquecimento.model;

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

@Table(name = "tb_pessoa")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
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
