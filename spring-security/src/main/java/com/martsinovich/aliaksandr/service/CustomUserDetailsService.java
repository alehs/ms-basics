package com.martsinovich.aliaksandr.service;

import com.martsinovich.aliaksandr.repository.RoleRepository;
import com.martsinovich.aliaksandr.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final LoginAttemptService loginAttemptService;

  public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository,
      LoginAttemptService loginAttemptService) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.loginAttemptService = loginAttemptService;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    final var maybeUser = userRepository.findUserByEmail(email);

    if (maybeUser.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    } else {
      if (loginAttemptService.isBlocked(email)) {
        throw new LockedException("User is blocked");
      }
    }

    final var user = maybeUser.get();
    log.debug("User '{}' exists", user.getEmail());

    final var roles = roleRepository.findAllByRoleIdEmail(user.getEmail());
    final var authorities = roles.stream()
        .map(role -> role.getRoleId().getRole())
        .toList();
    log.debug("User '{}' authorities: {}", user.getEmail(), authorities);

    return User
        .withUsername(user.getEmail())
        .password(user.getPassword())
        .authorities(authorities.toArray(String[]::new))
        .build();
  }
}
