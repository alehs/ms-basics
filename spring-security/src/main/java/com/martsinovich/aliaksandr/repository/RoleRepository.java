package com.martsinovich.aliaksandr.repository;

import com.martsinovich.aliaksandr.model.Role;
import com.martsinovich.aliaksandr.model.RoleId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, RoleId> {

  List<Role> findAllByRoleIdEmail(String email);
}
