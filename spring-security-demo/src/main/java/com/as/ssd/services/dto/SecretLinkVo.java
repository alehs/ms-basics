package com.as.ssd.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Pair;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecretLinkVo {

	private List<Pair<String, String>> links = new ArrayList<>();
	public SecretLinkVo withLink(String self, String hash) {
		links.add(Pair.of(self, hash));
		return this;
	}
}
