package br.com.franca.apienriquecimento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "TB_PESSOA")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa implements Serializable {

    @Id
    private Long id;
    private String cpf;
    private String nome;
    private String email;

}
