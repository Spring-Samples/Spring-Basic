package com.codebot.springbasic.swagger;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Spring Greetings Services")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.codebot.springbasic.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(metadata())
				.consumes(applicationMetadata())
				.produces(applicationMetadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("Spring Greetings Services")
				.description("Project for Spring Greetings Services")
				.version("1.0.0")
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.build();
	}

	private Set<String> applicationMetadata() {
		return new HashSet<>(Collections.singletonList("application/json"));
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
