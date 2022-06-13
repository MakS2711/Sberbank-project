package ru.dorofeev.sberbankproject.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Sberbank-project")
                                .version("1.0.0")
                                .description("REST-API проект, разрабатываемый в рамках курсовой работы Сбербанка, " +
                                        "посвещенный разработке микросервера \"Advertisement Management System\" " +
                                        "для системы персонального контента.")
                                .contact(
                                        new Contact()
                                                .email("Mektogon385@mail.ru")
                                                .url("https://github.com/MakS2711")
                                                .name("Dorofeev Maxim")
                                )
                );
    }
}
