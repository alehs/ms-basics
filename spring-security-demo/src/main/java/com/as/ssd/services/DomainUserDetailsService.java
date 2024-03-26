package com.as.ssd.services;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.as.ssd.data.model.Authority;
import com.as.ssd.data.model.User;
import com.as.ssd.data.model.UserLoginGuard;
import com.as.ssd.data.repository.UserLoginGuardRepository;
import com.as.ssd.data.repository.UserRepository;

@Slf4j
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserLoginGuardRepository loginGuardRepository;

	public DomainUserDetailsService(UserRepository userRepository, UserLoginGuardRepository loginGuardRepository) {
		this.userRepository = userRepository;
		this.loginGuardRepository = loginGuardRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public org.springframework.security.core.userdetails.User loadUserByUsername(String username) {
		log.debug("Authenticating {}", username);

		//Optional<UserLoginGuard>

		String lowercaseLogin = username.toLowerCase(Locale.ENGLISH);
		return userRepository
				.findOneWithAuthoritiesByUsername(lowercaseLogin)
				.map(user -> mapToSpringSecurityUser(lowercaseLogin, user))
				.orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
	}

	private org.springframework.security.core.userdetails.User mapToSpringSecurityUser(String lowercaseLogin, User user) {
		if (!user.isEnabled()) {
			throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
		}

		Optional<UserLoginGuard> loginGuard = loginGuardRepository.findByUserUsername(lowercaseLogin);
		if (loginGuard.isPresent()) {
			UserLoginGuard guard = loginGuard.get();
			if (guard.getFailedAttempts() >= 3) {
				throw new UserBlockedException("User " + lowercaseLogin + " is blocked until " + guard.getBlockedTill());
			}
		}

		List<GrantedAuthority> grantedAuthorities = user
				.getAuthorities()
				.stream()
				.map(Authority::getName)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}

