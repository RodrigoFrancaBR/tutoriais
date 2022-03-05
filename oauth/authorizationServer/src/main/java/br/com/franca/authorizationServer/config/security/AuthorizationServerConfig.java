package br.com.franca.authorizationServer.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.Arrays;
import java.util.List;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("WebApplicationClientId")
                    .secret(passwordEncoder.encode("WebApplicationClientSecret"))
                    // .authorizedGrantTypes("password", "refresh_token")
                    .authorizedGrantTypes("password")

                    ///.authorizedGrantTypes("password", "refresh_token")
                    .scopes("write", "read")
                    .accessTokenValiditySeconds(6 * 60 * 60)// 6 horas
                    ///.refreshTokenValiditySeconds(60 * 24 * 60 * 60) // 60 dias

//                .and()
//                .withClient("OtherWebApplicationClientId")
////                .secret(passwordEncoder.encode("OtherWebApplicationClientSecret"))
//                .secret(passwordEncoder.encode(""))
//                .authorizedGrantTypes("authorization_code")
//                .scopes("write", "read")
//                .redirectUris("http://localhost:8080")
//
//            .and()
//                    .withClient("BatchApplicationClientId")
//                        .secret(passwordEncoder.encode("BatchApplicationClientSecret"))
//                        .authorizedGrantTypes("client_credentials")
//                        .scopes("write", "read")
//
            .and()
                    .withClient("ResourcerServerClientID")
                    .secret(passwordEncoder.encode("ResourcerServerClientSecret"));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager);
//                .userDetailsService(userDetailsService)
//                .reuseRefreshTokens(false)
//                .tokenStore(redisTokenStore())
//                .tokenGranter(tokenGranter(endpoints));
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // security.checkTokenAccess("isAuthenticated()");
        security.checkTokenAccess("permitAll()");
                // .allowFormAuthenticationForClients();
    }

//    private TokenGranter tokenGranter(AuthorizationServerEndpointsConfigurer endpoints) {
//        PkceAuthorizationCodeTokenGranter pkceAuthorizationCodeTokenGranter = new PkceAuthorizationCodeTokenGranter(endpoints.getTokenServices(),
//                endpoints.getAuthorizationCodeServices(), endpoints.getClientDetailsService(),
//                endpoints.getOAuth2RequestFactory());
//
//        List<TokenGranter> granters = Arrays.asList(
//                pkceAuthorizationCodeTokenGranter, endpoints.getTokenGranter());
//
//        return new CompositeTokenGranter(granters);
//    }
//
//    @Bean
//    public TokenStore redisTokenStore(){
//        return new RedisTokenStore(redisConnectionFactory);
//    }

}
