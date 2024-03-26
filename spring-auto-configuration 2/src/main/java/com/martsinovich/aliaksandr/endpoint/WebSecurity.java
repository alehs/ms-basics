package com.martsinovich.aliaksandr.endpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class WebSecurity {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http,
      HandlerMappingIntrospector introspector) throws Exception {
    final var mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            auth -> {
              auth.requestMatchers(mvcMatcherBuilder.pattern("/actuator/connectionMeta")).authenticated();
              auth.anyRequest().permitAll();
            }
        )
        .headers(headers -> headers.frameOptions().disable()) // to allow access to /h2-console
        .httpBasic();

    return http.build();
  }
}
