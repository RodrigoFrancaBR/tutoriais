package br.com.franca.msenriquecimento.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorizationClient {
    private String access_token;
    private String token_type;
    private String expires_in;
    private String scope;
    private String token;
}
