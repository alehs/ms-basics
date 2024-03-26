package com.as.ssd.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.as.ssd.data.model.UserLoginGuard;
import com.as.ssd.data.repository.UserLoginGuardRepository;
import com.as.ssd.data.repository.UserRepository;

@Service("bruteForceProtectionService")
public class BruteForceProtectionService {

	@Value("${app.security.login.failedCount}")
	private int maxFailedLogins;


	private final UserRepository userRepository;
	private final UserLoginGuardRepository loginGuardRepository;

	public BruteForceProtectionService(UserRepository userRepository, UserLoginGuardRepository loginGuardRepository) {
		this.userRepository = userRepository;
		this.loginGuardRepository = loginGuardRepository;
	}

	public void loginSucceeded(String username) {
		loginGuardRepository.deleteByUserUsername(username);
	}

	public void loginFailed(String username) {
		loginGuardRepository.findByUserUsername(username).ifPresentOrElse(this::incrementFailedCount,
				() -> createNewUserLoginGuard(username));
	}

	private void createNewUserLoginGuard(String username) {
		UserLoginGuard userLoginGuard = new UserLoginGuard();
		userLoginGuard.setFailedAttempts(1);
		userLoginGuard.setUser(userRepository.findByUsername(username).get());
		userLoginGuard.setBlocked(false);
		userLoginGuard.setBlockedTill(null);
		loginGuardRepository.save(userLoginGuard);
	}

	private void incrementFailedCount(UserLoginGuard userLoginGuard) {
		userLoginGuard.setFailedAttempts(userLoginGuard.getFailedAttempts() + 1);
		if (userLoginGuard.getFailedAttempts() >= maxFailedLogins) {
			userLoginGuard.setBlocked(true);
			userLoginGuard.setBlockedTill(LocalDateTime.now().plusMinutes(1));
		}
		loginGuardRepository.save(userLoginGuard);
	}
}
