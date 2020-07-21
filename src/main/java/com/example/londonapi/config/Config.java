package com.example.londonapi.config;

import com.example.londonapi.gateway.IUsersFromExternal;
import com.example.londonapi.gateway.UsersFromExternal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * The configuration class for the API. The class contains configuration for the Swagger and a Bean for UsersFromExternal interface.
 */
@Configuration
public class Config {

    public static final String TAG_CONTROLLER = "Users";

    @Bean
    IUsersFromExternal createUsersFromExternal(){
        return new UsersFromExternal();
    }

    //Swagger Configuration
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.example.londonapi"))
                .build()
                .apiInfo(apiDetails())
                .tags(new Tag(TAG_CONTROLLER, "Users Endpoints"));
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "People of London",
                "Three endpoints. Get people who are:\n" +
                        "1-  Listed as living in London.\n" +
                        "2-  People coordinates are within 50 miles of London\n" +
                        "3-  Both of them (Living in London or those with current coordinates are within 50 miles of London)",
                "1.0",
                "https://opensource.org/ToS",
                new springfox.documentation.service.Contact("A.Sweilam", "https://asweilam.github.io/", "a.sweilam@outlook.com"),
                "API license",
                "https://opensource.org/ToS",
                Collections.emptyList());
    }

}
