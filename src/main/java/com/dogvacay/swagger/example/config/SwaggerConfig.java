package com.dogvacay.swagger.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
@EnableAutoConfiguration
public class SwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(new ApiInfo("Example microservice-like API, RESTful Spring services", "This example application is a reference demonstrating how to use Swagger annotations, <br>  improving documenting and testing of service end points.", null, null, null,
						null))
				// Here we disable auto generating of responses for
				// REST-endpoints
				.useDefaultResponseMessages(false)
				// Here we specify URI patterns which will be included in
				// Swagger docs. Use regex for this purpose.
				.includePatterns("/echo", "/submitperson");
	}

}