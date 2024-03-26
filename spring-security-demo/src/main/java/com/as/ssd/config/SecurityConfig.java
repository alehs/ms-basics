package com.as.ssd.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/", "/info", "/actuator/info", "/about").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers(HttpMethod.GET, "/users").hasAuthority("VIEW_INFO")
				.antMatchers(HttpMethod.POST, "/users").hasAuthority("VIEW_ADMIN")
				.antMatchers("/admin").hasAuthority("VIEW_ADMIN")
				.anyRequest().permitAll()
				.and()
				.csrf().disable()
				.headers().frameOptions().sameOrigin()
				.and()
				.httpBasic();
	}

	@Bean
	protected static PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
