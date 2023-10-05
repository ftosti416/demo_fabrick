package com.fabrik.demo.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

	@Value("${app.api.authSchema.name}")
	private String authSchemaName;
	@Value("${app.api.authSchema.value}")
	private String authSchemaValue;

	@Value("${app.api.apiKey.name}")
	private String apiKeyName;
	@Value("${app.api.apiKey.value}")
	private String apiKeyValue;

	@Value("${app.api.timezone.name}")
	private String timezoneName;
	@Value("${app.api.timezone.value}")
	private String timezoneValue;

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofMillis(60000)).setReadTimeout(Duration.ofMillis(60000))
				.defaultHeader(authSchemaName, authSchemaValue).defaultHeader(apiKeyName, apiKeyValue)
				.defaultHeader(timezoneName, timezoneValue).build();
	}

}
