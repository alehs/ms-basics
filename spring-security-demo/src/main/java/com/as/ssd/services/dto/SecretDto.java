package com.as.ssd.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SecretDto {
	private String username;
	private String secret;
}
