package com.as.ssd.data.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.as.ssd.data.model.UserLoginGuard;

@Repository
public interface UserLoginGuardRepository extends CrudRepository<UserLoginGuard, Long> {

	Optional<UserLoginGuard> findByUserUsername(String username);

	void deleteByUserUsername(String username);
}
