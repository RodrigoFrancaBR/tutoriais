package br.com.franca.msenriquecimento.config;

//import br.com.franca.msenriquecimento.domain.UsuarioAutenticado;

import br.com.franca.msenriquecimento.client.apienriquecimento.ApiEnriquecimentoService;
import br.com.franca.msenriquecimento.domain.AuthorizationClient;
import br.com.franca.msenriquecimento.service.AuthorizationServerService;
import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Configuration
public class FeignConfig implements RequestInterceptor {

    private static final String AUTH = "Authorization";

    @Autowired
    @Lazy
    private ApiEnriquecimentoService apiEnriquecimentoService;

    @Autowired
    @Lazy
    private AuthorizationServerService authorizationServiceService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("FeignConfig inicio apply():::::::");

        Optional.ofNullable(authorizationServiceService)
                .filter(e -> !requestTemplate.headers().containsKey(AUTH))
                .map(AuthorizationServerService::login)
                .map(AuthorizationClient::getToken)
                .ifPresent(token -> requestTemplate.header(AUTH, token));
        log.info(requestTemplate.url());
        log.info("FeignConfig fim apply():::::::");
    }

//    @Bean
//    public Client client() {
//        return new CustomFeignClient(null, null);
//    }
}
