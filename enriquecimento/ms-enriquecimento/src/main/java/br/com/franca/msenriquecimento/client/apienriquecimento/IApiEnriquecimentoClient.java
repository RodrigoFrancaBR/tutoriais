package br.com.franca.msenriquecimento.client.apienriquecimento;

import br.com.franca.msenriquecimento.client.dto.PessoaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "apiEnriquecimentoClient", url = "localhost:8080/api/enriquecimento/pessoas")
public interface IApiEnriquecimentoClient {

    @GetMapping(name = "find cpf", path = "/cpf/{cpf}", produces = MediaType.TEXT_XML_VALUE)
    PessoaResponse obterCpf(String cpf);
}
