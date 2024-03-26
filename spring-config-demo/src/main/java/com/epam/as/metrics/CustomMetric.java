package com.epam.as.metrics;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomMetric implements InfoContributor {
	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("customInfoOverloaded", "Hello world");
	}
}
