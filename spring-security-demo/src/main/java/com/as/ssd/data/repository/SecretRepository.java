package com.as.ssd.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.as.ssd.data.model.Secret;

@Repository
public interface SecretRepository extends JpaRepository<Secret, Long> {
	boolean existsByHash(String hash);

	Optional<Secret> findByHash(String hash);
}
