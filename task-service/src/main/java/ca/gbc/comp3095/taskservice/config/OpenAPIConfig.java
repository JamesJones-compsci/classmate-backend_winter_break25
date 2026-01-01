package ca.gbc.comp3095.taskservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI taskServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Service API")
                        .description("REST API for managing tasks in the ClassMate project")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("James Jones")
                                .email("james.jones@example.com"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")))
                .externalDocs(new ExternalDocumentation()
                        .description("ClassMate Backend Docs")
                        .url("https://github.com/JamesJones-compsci/classmate-backend_winter_break25"));
    }
}