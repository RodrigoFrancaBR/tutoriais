package br.com.franca.msenriquecimento.service;

import br.com.franca.msenriquecimento.client.apienriquecimento.IAuthorizationServerClient;
import br.com.franca.msenriquecimento.domain.AuthorizationClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthorizationServerService {

    private final IAuthorizationServerClient authorizationServerClient;

    public AuthorizationClient login() {
        log.info("inicio login():::::::");
        var authorizationClient = authorizationServerClient.getToken("client_credentials");
        log.info("AuthorizationClient: {}", authorizationClient);
        String access_token = authorizationClient.getAccess_token();
        authorizationClient.setToken("Bearer "+ access_token);
        return authorizationClient;
    }
}
