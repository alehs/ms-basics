package com.as.ssd.web;

import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "about")
@Component
public class CustomInfoEndpoint {
	@ReadOperation
	public Map<String,String> getCustomInfo() {
		return Map.of("about", "Hello world");
	}
}
