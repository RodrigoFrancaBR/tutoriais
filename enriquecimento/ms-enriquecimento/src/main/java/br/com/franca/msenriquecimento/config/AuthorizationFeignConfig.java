package br.com.franca.msenriquecimento.config;

//import br.com.franca.msenriquecimento.domain.UsuarioAutenticado;

import br.com.franca.msenriquecimento.client.apienriquecimento.ApiEnriquecimentoService;
import br.com.franca.msenriquecimento.domain.AuthorizationClient;
import feign.Headers;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Slf4j
@Configuration
public class AuthorizationFeignConfig implements RequestInterceptor {

    private static final String PATH_URL = "token";
    private static final String AUTH = "Authorization";

    @Autowired
    private ApiEnriquecimentoService service;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("AuthorizationFeignConfig inicio apply():::::::");
        requestTemplate.header("Authorization"
                , "Basic QmF0Y2hBcHBsaWNhdGlvbkNsaWVudElkOkJhdGNoQXBwbGljYXRpb25DbGllbnRTZWNyZXQ="
                ,"Content-Type", "application/x-www-form-urlencoded"
        );
        
        log.info(requestTemplate.url());

//        Optional.ofNullable(service)
//                .filter(e -> requestTemplate.headers().containsKey(AUTH))
//                .map(ApiEnriquecimentoService::login)
//                .map(AuthorizationClient::getToken)
//                .ifPresent(token -> requestTemplate.header(AUTH, token));
        log.info("AuthorizationFeignConfig fim apply():::::::");
    }

//    @Bean
//    public Client client() {
//        return new CustomFeignClient(null, null);
//    }
}
