package br.com.franca.msenriquecimento.config;

import br.com.franca.msenriquecimento.domain.UsuarioAutenticado;
import br.com.franca.msenriquecimento.domain.service.EnriquecimentoService;
import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Configuration
public class FeignConfig implements RequestInterceptor {

    private static final String PATH_URL = "token";

    @Autowired
    private EnriquecimentoService service;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("inicio apply():::::::");

        Optional.ofNullable(service)
                .filter(auth -> !requestTemplate.url().contains(PATH_URL))
                .map(EnriquecimentoService::efetuarLogin)
                .map(UsuarioAutenticado::getToken)
                .ifPresent(token -> requestTemplate.queries(Map.of(PATH_URL, Collections.singleton(token))));

        log.info("fim apply():::::::");
    }

    @Bean
    public Client client() {
        return new CustomFeignClient(null, null);
    }
}
