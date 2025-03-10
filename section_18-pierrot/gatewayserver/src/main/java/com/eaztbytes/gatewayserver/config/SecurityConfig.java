package com.eaztbytes.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain (ServerHttpSecurity httpSecurity) {

        httpSecurity.authorizeExchange(exchanges ->
                        exchanges.pathMatchers("/eazybank/accounts/**").hasRole("ACCOUNTS")
                                .pathMatchers("/eazybank/cards/**").authenticated()
                                .pathMatchers("/eazybank/loans/**").permitAll())
                // sets this server as Oauth2 Resource Server with JWT-Tokens
                .oauth2ResourceServer().jwt()
                // sets the jwt-Converter
                .jwtAuthenticationConverter(grantedAuthoritiesExtractor());

        httpSecurity.csrf().disable();
        return httpSecurity.build();

    }

    Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor() {
        JwtAuthenticationConverter jwtAuthenticationConverter  = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }

}
