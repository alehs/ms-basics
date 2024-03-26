package com.as.ssd.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.ssd.data.model.AuthoritiesConstants;
import com.as.ssd.data.model.Secret;
import com.as.ssd.services.dto.SecretDto;
import com.as.ssd.services.dto.SecretHashVo;
import com.as.ssd.services.SecretService;
import com.as.ssd.services.dto.SecretLinkVo;

@RestController
@RequestMapping("/secrets")
public class UserSecretController {
	private final SecretService secretService;

	public UserSecretController(SecretService secretService) {
		this.secretService = secretService;
	}

	@GetMapping
	@PreAuthorize("hasAuthority(" + AuthoritiesConstants.ADMIN +")")
	public List<Secret> getAll() {
		return secretService.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority(" + AuthoritiesConstants.STANDARD +")")
	public SecretLinkVo makeSecret(@RequestBody Secret secret) {
		return secretService.makeSecret(secret);
	}

	@GetMapping("/{hash}")
	@PreAuthorize("hasAuthority(" + AuthoritiesConstants.STANDARD +")")
	public ResponseEntity<SecretDto> getSecret(@PathVariable(value = "hash", required = true) String hash) {
		if (secretService.hasSecret(hash)) {
			return ResponseEntity.ok(secretService.getSecret(hash));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
