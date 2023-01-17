package com.craftsman.restservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.craftsman.restservice.domain.mappers.RestServiceFactoryMapperImpl;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class RestServiceConfig {
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.api-docs.version}") String appVersion,
			@Value("${app.openapi.security.scheme}") String securityScheme,
			@Value("${app.openapi.security.basic}") String schemeBasic, @Value("${app.openapi.title}") String title,
			@Value("${app.openapi.description}") String description,
			@Value("${app.openapi.license.name}") String licenseName,
			@Value("${app.openapi.license.url}") String licenseUrl,
			@Value("${app.openapi.contact.name}") String contactName,
			@Value("${app.openapi.contact.url}") String contactUrl) {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes(securityScheme,
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme(schemeBasic)))
				.info(new Info().title(title).description(description).version(appVersion)
						.license(new License().name(licenseName).url(licenseUrl))
						.contact(new Contact().name(contactName).url(contactUrl)));
	}
	/*
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.api-docs.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info().title("RestService API").version(appVersion).description("This is a RestService Api.")
						.license(new License().name("Apache 2.0").url("https://opensource.org/licenses/Apache-2.0"))
						.contact(new Contact().url("http://cadb-craftsman.com").name("Craftsman")));
	}
	*/
	@Bean
	public RestServiceFactoryMapperImpl getFactoryMapper() {
		return new RestServiceFactoryMapperImpl();
	}

}
