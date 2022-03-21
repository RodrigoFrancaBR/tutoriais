package br.com.franca.msenriquecimento.config;

import br.com.franca.msenriquecimento.domain.AuthorizationClient;
import br.com.franca.msenriquecimento.service.AuthorizationServerService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

@Slf4j
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    private static final String AUTH = "Authorization";

    @Autowired
    @Lazy
    private AuthorizationServerService authorizationServiceService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("FeignConfig inicio request interceptor():::::::");
        Optional.ofNullable(authorizationServiceService)
                .filter(e -> !requestTemplate.headers().containsKey(AUTH))
                .map(AuthorizationServerService::login)
                .map(AuthorizationClient::getAccessToken)
                .ifPresent(accessToken -> requestTemplate.header(AUTH, accessToken));
        log.info(requestTemplate.url());
        log.info("FeignConfig fim apply():::::::");
    }

//    @Bean
//    public Client client() {
//        return new CustomFeignClient(null, null);
//    }
}
