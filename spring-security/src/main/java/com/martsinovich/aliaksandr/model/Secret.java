package com.martsinovich.aliaksandr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "secrets")
public class Secret {

  @Id
  private String email;

  private String secret;

  private String token;

  private String link;

  public Secret() {
  }

  public Secret(String email, String secret, String token, String link) {
    this.email = email;
    this.secret = secret;
    this.token = token;
    this.link = link;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String token) {
    this.secret = token;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "Secret{" +
        "email='" + email + '\'' +
        ", secret='" + secret + '\'' +
        ", token='" + token + '\'' +
        ", link='" + link + '\'' +
        '}';
  }
}
