package com.cuba.ForumHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) // Alterado para OAS_30
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cuba.forumhub"))
                .paths(PathSelectors.any())
                .build();
    }
}

