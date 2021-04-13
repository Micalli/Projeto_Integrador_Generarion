package com.projeto_integrador_gen.egide.swagger;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto_integrador_gen.egide.model.Postagem;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.projeto_integrador_gen.egide.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Égide").description("API do Projeto Integrador Generation").version("1.0")
				.contact(contact()).build();
	}

	private Contact contact() {
		return new Contact("Angela Caperuzzo, Gabriel Aronne, Izaque Liborio, Bruno Micalli, Mariana Santos","https://github.com/AngelaCaperuzzo",
				"Desenvolvedores full stack Java Jr");
	}

}
