package br.com.franca.apienriquecimento.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_cliente")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente implements Serializable {

    @Id
    private Long id;
    private String nome;
    private String email;
    private String cpf;

}
