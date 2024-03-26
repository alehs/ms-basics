package com.martsinovich.aliaksandr.configuration;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Value("${security.encryption.password:VeryComplicatedPassword}")
  private String encryptedPassword;

  @Value("${security.encryption.salt:5c0744940b5c369b}")
  private String encryptedSalt;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationFailureHandler
      authenticationFailureHandler, AuthenticationSuccessHandler authenticationSuccessHandler)
      throws Exception {
    return http
        .csrf(Customizer.withDefaults())
        .authorizeHttpRequests(auth ->
            auth
                .requestMatchers("/about", "/css/**", "/login*", "/blocked")
                .permitAll()
                .requestMatchers("/info").hasAuthority("VIEW_INFO")
                .requestMatchers("/admin").hasAuthority("VIEW_ADMIN")
                .requestMatchers("/secret**", "/secret-generate").hasAuthority("STANDARD")
                .anyRequest()
                .authenticated()
        )
        .formLogin(formLogin -> formLogin.loginPage("/login")
            .failureHandler(authenticationFailureHandler)
            .successHandler(authenticationSuccessHandler)
            .permitAll())
        .logout(logout -> logout
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/logoutSuccess")
            .permitAll()
        )
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    final var encoders = new HashMap<String, PasswordEncoder>();
    encoders.put("bcrypt", new BCryptPasswordEncoder());

    return new DelegatingPasswordEncoder("bcrypt", encoders);
  }

  @Bean
  public TextEncryptor textEncryptor() {
    return Encryptors.text(encryptedPassword, encryptedSalt);
  }

  @Bean
  public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
      PasswordEncoder passwordEncoder) {
    final var provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(passwordEncoder);

    return provider;
  }
}
