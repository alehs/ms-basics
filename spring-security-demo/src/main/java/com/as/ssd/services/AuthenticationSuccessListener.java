package com.as.ssd.services;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
	@Resource
	private BruteForceProtectionService bruteForceProtectionService;

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		String username = event.getAuthentication().getName();
		bruteForceProtectionService.loginSucceeded(username);
	}
}
