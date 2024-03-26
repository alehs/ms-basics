package com.martsinovich.aliaksandr.configuration.bruteforce;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  private static final Logger log = LoggerFactory.getLogger(
      CustomAuthenticationFailureHandler.class);

  private static final String USER_BLOCKED_MESSAGE = "User is blocked";
  private static final String BAD_CREDENTIALS_MESSAGE = "Bad credentials";

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    super.setDefaultFailureUrl("/login?error");
    super.onAuthenticationFailure(request, response, exception);

    String error = BAD_CREDENTIALS_MESSAGE;

    if (exception.getMessage().equalsIgnoreCase(USER_BLOCKED_MESSAGE)) {
      error = USER_BLOCKED_MESSAGE;
    }

    request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, error);
  }
}
