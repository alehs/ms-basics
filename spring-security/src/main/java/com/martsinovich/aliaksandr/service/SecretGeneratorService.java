package com.martsinovich.aliaksandr.service;

import com.martsinovich.aliaksandr.model.Secret;
import com.martsinovich.aliaksandr.repository.SecretRepository;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class SecretGeneratorService {

  private static final Logger log = LoggerFactory.getLogger(SecretGeneratorService.class);
  private final SecretRepository secretRepository;
  private final TextEncryptor textEncryptor;
  @Value("${app.host:http://localhost:8080/secret/}")
  private String host;

  public SecretGeneratorService(SecretRepository secretRepository, TextEncryptor textEncryptor) {
    this.secretRepository = secretRepository;
    this.textEncryptor = textEncryptor;
  }

  public String generate(String email, String payload) {
    final var encodedPayload = textEncryptor.encrypt(payload);
    final var token = token();
    final var url = generateUrl(token);

    secretRepository.save(new Secret(email, encodedPayload, token, url));

    return url;
  }

  @Transactional
  public Secret provide(String token) {
    final var maybeSecret = secretRepository.findByToken(token);

    if (maybeSecret.isPresent()) {
      final var secret = maybeSecret.get();

      secretRepository.delete(secret);
      
      secret.setSecret(textEncryptor.decrypt(secret.getSecret()));

      return maybeSecret.get();
    }

    return null;
  }

  private String token() {
    return UUID.randomUUID().toString();
  }

  private String generateUrl(String token) {
    return host + token;
  }
}
