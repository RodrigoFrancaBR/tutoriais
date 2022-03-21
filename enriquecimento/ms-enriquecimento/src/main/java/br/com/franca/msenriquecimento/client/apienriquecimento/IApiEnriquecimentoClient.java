package br.com.franca.msenriquecimento.client.apienriquecimento;

import br.com.franca.msenriquecimento.client.dto.PessoaResponse;
import br.com.franca.msenriquecimento.config.FeignRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-enriquecimento-client", url = "${apienriquecimento.url}"
        , configuration = FeignRequestInterceptor.class)
public interface IApiEnriquecimentoClient {

    @GetMapping(path = "cpf/{cpf}", produces = MediaType.TEXT_XML_VALUE)
    PessoaResponse enriquecerAluno(@PathVariable String cpf);

}
