package com.martsinovich.aliaksandr.model.dto;

public class SecretDto {

  private String secret;

  public SecretDto() {
  }

  public SecretDto(String secret) {
    this.secret = secret;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  @Override
  public String toString() {
    return "SecretDto{" +
        "secret='" + secret + '\'' +
        '}';
  }
}
