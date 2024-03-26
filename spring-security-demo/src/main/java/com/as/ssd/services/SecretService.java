package com.as.ssd.services;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.as.ssd.data.model.Secret;
import com.as.ssd.data.repository.SecretRepository;
import com.as.ssd.services.dto.SecretDto;
import com.as.ssd.services.dto.SecretLinkVo;

@Service
public class SecretService {

	private final SecretRepository secretRepository;
	private final UserService userService;

	private final PasswordEncoder passwordEncoder;
	@Value("${app.security.encryptor.pass}")
	private String encryptorPass;
	@Value("${app.security.encryptor.salt}")
	private String encryptorSalt;

	public SecretService(SecretRepository secretRepository, UserService userService, PasswordEncoder passwordEncoder) {
		this.secretRepository = secretRepository;
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	public List<Secret> findAll() {
		return secretRepository.findAll();
	}

	public SecretLinkVo makeSecret(Secret secret) {
		String username = currentUser().toLowerCase();
		Secret toSave = userService.findByUsername(username).map(user -> {
			Secret newSecret = new Secret();
			newSecret.setSecret(Encryptors.text(encryptorPass, encryptorSalt).encrypt(secret.getSecret()));
			newSecret.setHash(passwordEncoder.encode(secret.getSecret()));
			newSecret.setUser(user);
			return newSecret;
		}).orElseThrow(() -> new RuntimeException("User not found"));

		secretRepository.save(toSave);
		return new SecretLinkVo().withLink("self", "/secrets/" + URLEncoder.encode(toSave.getHash()));
	}

	public boolean hasSecret(String hash) {
		return secretRepository.findByHash(hash).isPresent();
	}

	public SecretDto getSecret(String hash) {
		Secret secret = secretRepository.findByHash(hash)
			.map(savedSecret -> restoreSecret(savedSecret)).orElseThrow(() -> new RuntimeException("Secret not found"));
		secretRepository.delete(secret);
		return new SecretDto(secret.getUser().getUsername(), secret.getSecret());
	}

	private Secret restoreSecret(Secret savedSecret) {
		Secret secret = new Secret();
		secret.setSecret(Encryptors.text(encryptorPass, encryptorSalt).encrypt(savedSecret.getSecret()));
		secret.setUser(savedSecret.getUser());
		return secret;
	}

	private static String currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		} else if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
			return springSecurityUser.getUsername();
		} else if (authentication.getPrincipal() instanceof String) {
			return (String) authentication.getPrincipal();
		}
		return null;
	}
}
