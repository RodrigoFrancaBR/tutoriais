package br.com.franca.msenriquecimento.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JacksonXmlRootElement(localName = "api-enriquecimento", namespace = "http://api-enriquecimento.com.br/")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class PessoaResponse {
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
