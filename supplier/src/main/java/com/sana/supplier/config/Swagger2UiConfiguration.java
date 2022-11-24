package com.sana.supplier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sana")).paths(PathSelectors.any()).build()
				.apiInfo(getApiInfo());

	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Sana", "", "Sana@gmail.com");

		return new ApiInfoBuilder().title("Supplier Microservice").description(" Description of the API for the Supplier Microservice").contact(contact)
				.version("0.1").build();
	}
}
