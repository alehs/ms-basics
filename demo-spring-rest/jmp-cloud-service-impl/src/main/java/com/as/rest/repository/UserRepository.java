package com.as.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.as.rest.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
