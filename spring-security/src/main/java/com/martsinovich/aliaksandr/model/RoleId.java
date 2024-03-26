package com.martsinovich.aliaksandr.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoleId implements Serializable {

  private String email;
  private String role;

  public RoleId() {
  }

  public RoleId(String email, String role) {
    this.email = email;
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleId roleId = (RoleId) o;
    return Objects.equals(email, roleId.email) && Objects.equals(role,
        roleId.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, role);
  }

  @Override
  public String toString() {
    return "RoleId{" +
        "email='" + email + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}
