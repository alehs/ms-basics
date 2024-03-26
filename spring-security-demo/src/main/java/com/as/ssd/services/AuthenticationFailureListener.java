package com.as.ssd.services;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
	@Resource
	private BruteForceProtectionService bruteForceProtectionService;

	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		String username = event.getAuthentication().getName();
		bruteForceProtectionService.loginFailed(username);
	}
}
