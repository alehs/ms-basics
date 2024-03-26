package com.martsinovich.aliaksandr.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

  @EmbeddedId
  private RoleId roleId;

  public Role() {
  }

  public Role(RoleId roleId) {
    this.roleId = roleId;
  }

  public RoleId getRoleId() {
    return roleId;
  }

  public void setRoleId(RoleId roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "Role{" +
        "roleId=" + roleId +
        '}';
  }
}
