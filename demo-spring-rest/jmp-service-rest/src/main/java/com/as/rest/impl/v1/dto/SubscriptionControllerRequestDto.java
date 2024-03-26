package com.as.rest.impl.v1.dto;

import lombok.Data;

import java.util.List;

import com.as.rest.dto.SubscriptionRequestDto;

@Data
public class SubscriptionControllerRequestDto {
	private String method;
	private List<Param> params;

	public SubscriptionRequestDto toSubscriptionRequest() {
		return new SubscriptionRequestDto()
				.id(this.getId())
				.userId(Long.parseLong(findByName("userId", params)));
	}

	public Long getId() {
		String val = findByName("id", params);
		if (val == null) {
			return null;
		}
		return Long.parseLong(val);
	}

	private String findByName(String name, List<Param> params) {
		return params.stream().filter(p -> p.getName().equals(name)).findFirst().map(p -> p.getValue()).orElse(null);
	}
}
