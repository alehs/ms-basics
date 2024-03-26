package com.martsinovich.aliaksandr.repository;

import com.martsinovich.aliaksandr.model.Secret;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends CrudRepository<Secret, String> {

  Optional<Secret> findByToken(String token);

}
