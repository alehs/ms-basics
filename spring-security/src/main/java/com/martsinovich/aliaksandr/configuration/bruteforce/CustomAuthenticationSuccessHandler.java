package com.martsinovich.aliaksandr.configuration.bruteforce;

import com.martsinovich.aliaksandr.service.LoginAttemptService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private final LoginAttemptService loginAttemptService;

  public CustomAuthenticationSuccessHandler(LoginAttemptService loginAttemptService) {
    this.loginAttemptService = loginAttemptService;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    loginAttemptService.registerLoginSuccess(authentication.getName());
    super.onAuthenticationSuccess(request, response, authentication);
  }
}
