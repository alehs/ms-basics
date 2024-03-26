package com.martsinovich.aliaksandr.service;

import com.martsinovich.aliaksandr.model.BlockedUser;
import java.time.LocalDateTime;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginAttemptService {

  private static final Logger log = LoggerFactory.getLogger(LoginAttemptService.class);

  private final CacheService<BlockedUser> cacheService;

  @Value("${brute-force.max-failed-logins:3}")
  private int maxFailedLogins;

  public LoginAttemptService(CacheService<BlockedUser> cacheService) {
    this.cacheService = cacheService;
  }

  public void registerLoginFailure(String email) {
    var blockedUser = cacheService.get(email);

    if (Objects.nonNull(blockedUser)) {
      blockedUser.setAttempts(blockedUser.getAttempts() + 1);
    } else {
      blockedUser = new BlockedUser(email, 1, null);
    }

    if (isBlocked(email) && Objects.isNull(blockedUser.getTimestamp())) {
      blockedUser.setTimestamp(LocalDateTime.now());
    }

    cacheService.add(email, blockedUser);
  }

  public boolean isBlocked(String email) {
    final var blockedUser = cacheService.get(email);

    if (Objects.nonNull(blockedUser)) {
      return blockedUser.getAttempts() >= maxFailedLogins;
    }

    return false;
  }

  public void registerLoginSuccess(String email) {
    cacheService.remove(email);
  }
}

