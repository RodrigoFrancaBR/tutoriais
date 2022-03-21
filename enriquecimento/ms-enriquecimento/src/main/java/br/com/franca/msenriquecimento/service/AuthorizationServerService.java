package br.com.franca.msenriquecimento.service;

import br.com.franca.msenriquecimento.client.apienriquecimento.IAuthorizationServerClient;
import br.com.franca.msenriquecimento.domain.AuthorizationClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthorizationServerService {
    @Value("${authorization-server.basic-auth}")
    private String authorization;

    @Value("${authorization-server.content-type}")
    private String contentType;

    @Value("${authorization-server.grant-type.client-credentials}")
    private String grantType;

    private final IAuthorizationServerClient authorizationServerClient;

    public AuthorizationClient login() {
        log.info("inicio login():::::::");
        var authorizationClient = authorizationServerClient.getToken(authorization, contentType, grantType);
        log.info("AuthorizationClient: {}", authorizationClient);
        authorizationClient.setAccessToken("Bearer " + authorizationClient.getAccessToken());
        return authorizationClient;
    }
}
