package com.epam.as.metrics;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "customInfo")
@Component
public class CustomInfoEndpoint {
	@ReadOperation
	public Map<String,String> getCustomInfo() {
		return Map.of("customInfo", "Hello world");
	}
}
