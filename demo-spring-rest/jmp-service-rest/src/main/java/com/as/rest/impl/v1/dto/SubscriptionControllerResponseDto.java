package com.as.rest.impl.v1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.as.rest.dto.SubscriptionResponseDto;

@Data
@Builder
public class SubscriptionControllerResponseDto {

	private List<SubscriptionResponseDto> data;

	public static SubscriptionControllerResponseDto of(SubscriptionResponseDto item) {
		var builder = SubscriptionControllerResponseDto.builder();
		if (item != null) {
			builder.data(List.of(item));
		}
		return builder.build();
	}

	public static SubscriptionControllerResponseDto ofAll(List<SubscriptionResponseDto> all) {
		return SubscriptionControllerResponseDto.builder()
				.data(all)
				.build();
	}
}
