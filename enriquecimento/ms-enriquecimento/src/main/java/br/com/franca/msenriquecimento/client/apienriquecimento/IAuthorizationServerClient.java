package br.com.franca.msenriquecimento.client.apienriquecimento;

// import br.com.franca.msenriquecimento.config.AuthorizationFeignConfig;

import br.com.franca.msenriquecimento.config.FeignRequestInterceptor;
import br.com.franca.msenriquecimento.domain.AuthorizationClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "authorization-server-client",
        url = "${authorization-server.url}", configuration = FeignRequestInterceptor.class)
public interface IAuthorizationServerClient {

    @PostMapping(path = "oauth/token", produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorizationClient getToken(@RequestHeader("Authorization") String authorization,
                                 @RequestHeader("Content-Typ") String contentType,
                                 @RequestParam(name = "grant_type") String grantType);
}
