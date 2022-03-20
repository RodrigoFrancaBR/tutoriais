package br.com.franca.msenriquecimento.client.apienriquecimento;

import br.com.franca.msenriquecimento.config.AuthorizationFeignConfig;
import br.com.franca.msenriquecimento.config.FeignConfig;
import br.com.franca.msenriquecimento.domain.AuthorizationClient;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "authorization-server-client",
        url = "http://localhost:8081", configuration = AuthorizationFeignConfig.class)
public interface IAuthorizationServerClient {

    @PostMapping(path = "oauth/token", produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorizationClient getToken(@RequestParam String grant_type);
}
