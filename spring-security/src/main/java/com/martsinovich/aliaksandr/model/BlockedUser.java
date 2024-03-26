package com.martsinovich.aliaksandr.model;

import java.time.LocalDateTime;

public class BlockedUser {

  private String email;

  private Integer attempts;

  private LocalDateTime timestamp;

  public BlockedUser(String email, Integer attempts, LocalDateTime timestamp) {
    this.email = email;
    this.attempts = attempts;
    this.timestamp = timestamp;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getAttempts() {
    return attempts;
  }

  public void setAttempts(Integer attempts) {
    this.attempts = attempts;
  }

  @Override
  public String toString() {
    return "BlockedUser{" +
        "email='" + email + '\'' +
        ", attempts=" + attempts +
        ", timestamp=" + timestamp +
        '}';
  }
}
