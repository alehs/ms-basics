package com.martsinovich.aliaksandr.model;

public class ConnectionMetadata {
  private String username;

  private String url;

  public ConnectionMetadata() {
  }

  public ConnectionMetadata(String username, String url) {
    this.username = username;
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "UserCredentials{" +
        "username='" + username + '\'' +
        ", url='" + url + '\'' +
        '}';
  }
}
