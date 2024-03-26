package com.martsinovich.aliaksandr.configuration.bruteforce;

import com.martsinovich.aliaksandr.service.LoginAttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureListener implements
    ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

  private static final Logger log = LoggerFactory.getLogger(AuthenticationFailureListener.class);

  private final LoginAttemptService service;

  public AuthenticationFailureListener(LoginAttemptService service) {
    this.service = service;
  }

  @Override
  public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
    service.registerLoginFailure(event.getAuthentication().getName());
  }
}
